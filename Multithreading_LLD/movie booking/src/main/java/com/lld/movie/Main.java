package com.lld.movie;


import com.lld.movie.concurrency.ILockProvider;
import com.lld.movie.concurrency.ImMemoryLockProvider;
import com.lld.movie.entities.*;
import com.lld.movie.entities.enums.SEAT_TYPE;
import com.lld.movie.repository.SeatManager;
import com.lld.movie.repository.ShowManager;
import com.lld.movie.repository.TheatreManager;
import com.lld.movie.strategy.payment.CreditCard;
import com.lld.movie.strategy.payment.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {


		// ******************** actors *************************

		// movies
		Movie m1 = new Movie(1 , "Inception" , "Sci-Fi" , 148);
		// m1 - will be shown in screen 1 of theatre t1 at 10:00 AM , 12:30 PM , 5:00 PM

		Movie m2 = new Movie(2 , "Interstellar" , "Fiction" , 169);
		// m2 - will be shown in screen 2 of theatre t1 at 11:00 AM , 3:00 PM , 7:00 PM

		// shows
		LocalDateTime show1Date = LocalDateTime.of(2026 , 4 , 1 , 10 , 0);
		Show show1 = new Show(1 , show1Date , 60 , m1  );
		Show show2 = new Show(2 , show1Date.plusHours((long) 1.5) , 60 , m1  );
		Show show3 = new Show(3 , show1Date.plusHours(7) , 60 , m1  );

		Show show4 = new Show(4 , show1Date.plusHours(1) , 60 , m2  );
		Show show5 = new Show(5 , show1Date.plusHours(5) , 60 , m2  );
		Show show6 = new Show(6 , show1Date.plusHours(9) , 60 , m2  );

		// saving into the repositoyr
		ShowManager showManager = new ShowManager();
		showManager.addShow(show1);
		showManager.addShow(show2);
		showManager.addShow(show3);
		showManager.addShow(show4);
		showManager.addShow(show5);
		showManager.addShow(show6);

		// screens
		Screen s1 = new Screen(1 , "Screen 1");

		// screen1 will have 3 shows of movie m1
		s1.addShow(show1);
		s1.addShow(show2);
		s1.addShow(show3);

		// screen2 will have 3 shows of movie m2
		s1.addShow(show4);
		s1.addShow(show5);
		s1.addShow(show6);

		// creating seats for screen 1
		int k = 1;
		for( int i = 1 ; i <= 2 ; i++ ) {
			for( int j=1;j<=5;j++ )
				s1.addSeat( new Seat(k++ , i , j , "Seat-R"+i+"-C"+j , j<=3 ? SEAT_TYPE.REGULAR : SEAT_TYPE.PREMIUM ) );
		}

		// theatres
		TheatreManager theatreManager = new TheatreManager();
		Theatre t1 = new Theatre("PVR" , "Mumbai");		// will use this only for now
		Theatre t2 = new Theatre("INOX" , "CCU");

		theatreManager.addTheatreToCity(1 , t1);  // extra
		theatreManager.addTheatreToCity(2 , t2);	// extra
		t1.addScreen(s1);

		// users
		User user1 = new User(1 , "Alice" , "alice@mail.com");

		// *************************** actions ******************************

		// req 1 : fetching all the movies in theatre t1 in all screens with time
		System.out.println("Current movies ongoing in Theatre 1");
		theatreManager.getMoviesInTheatre(1).forEach( show -> {
			System.out.println("Show ID: "+show.getShowId()+" Movie : " + show.getMovie().getName() + " Genre : " + show.getMovie().getGenre() + " Duration : " + show.getMovie().getDuration() +" Start time :"+show.getStartTime());
		});

		// req2 : show all the available seats (for T1 > S1 > showid 1)

		// for simplicity we will think we have only 1 theatre and we will consider the first screen
		System.out.println("\nAll seats for Theatre 1 , Screen 1 , Show 1");

		ILockProvider iLockProvider = new ImMemoryLockProvider();
		SeatManager seatManager = new SeatManager();
		MovieBookingManager bookingManager = new MovieBookingManager(iLockProvider , theatreManager , showManager , seatManager);

		bookingManager.getAllFreeSeats(1 , 1 , 1).forEach( seat -> {
			System.out.println("Seat ID: "+seat.getSeatId()+" Seat Number : " + seat.getSeatNumber() + " Row : " + seat.getRow() + " Column : " + seat.getCol() + " Type : " + seat.getSeatType());
		});


		// new user1 will try to book some seats - should be booked
		List<Seat> seatsToBeBooked = List.of( s1.getSeatMap().get(1) , s1.getSeatMap().get(2) , s1.getSeatMap().get(6) );
		bookingManager.createBooking(1 , seatsToBeBooked , user1 );
		bookingManager.confirmBooking(1 , seatsToBeBooked , user1 , new CreditCard() );

		bookingManager.getAllFreeSeats(1 , 1 , 1).forEach( seat -> {
			System.out.println("Seat ID: "+seat.getSeatId()+" Seat Number : " + seat.getSeatNumber() + " Row : " + seat.getRow() + " Column : " + seat.getCol() + " Type : " + seat.getSeatType());
		});

		// concurrent bookng scenario

		ExecutorService executor = Executors.newFixedThreadPool(2);


		Runnable user2Task = ()->{
			User user2 = new User(2 , "Blice" , "blice@mail.com");
			bookingManager.createBooking(1 , List.of( s1.getSeatMap().get(4) , s1.getSeatMap().get(5) ) , user2 );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookingManager.confirmBooking(1 , List.of( s1.getSeatMap().get(4) , s1.getSeatMap().get(5) ) , user2 , new CreditCard() );
		};

		Runnable user3Task = ()->{
			User user3 = new User(3 , "Clice" , "clice@mail.com");
			bookingManager.createBooking(1 , List.of( s1.getSeatMap().get(5) , s1.getSeatMap().get(7) ) , user3 );
			bookingManager.confirmBooking(1 , List.of( s1.getSeatMap().get(5) , s1.getSeatMap().get(7) ) , user3  , new CreditCard());
		};


		executor.submit(user2Task);
		executor.submit(user3Task);

		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);


		bookingManager.getAllFreeSeats(1 , 1 , 1).forEach( seat -> {
			System.out.println("Seat ID: "+seat.getSeatId()+" Seat Number : " + seat.getSeatNumber() + " Row : " + seat.getRow() + " Column : " + seat.getCol() + " Type : " + seat.getSeatType());
		});

	}

}
