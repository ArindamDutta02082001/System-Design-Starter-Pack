package com.lld.movie;

import com.lld.movie.concurrency.ILockProvider;
import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;
import com.lld.movie.entities.enums.SEAT_TYPE;
import com.lld.movie.repository.SeatManager;
import com.lld.movie.repository.ShowManager;
import com.lld.movie.repository.TheatreManager;
import com.lld.movie.strategy.payment.PaymentStrategy;
import lombok.Setter;

import java.util.*;

public class MovieBookingManager {



    // master manager class for aggregating all other submanagers

    ILockProvider iLockProvider;
    TheatreManager theatreManager;

    ShowManager showManager;

    SeatManager seatManager;



    public MovieBookingManager(ILockProvider iLockProvider , TheatreManager theatreManager , ShowManager showManager  , SeatManager seatManager) {
        this.iLockProvider = iLockProvider;
        this.theatreManager = theatreManager;
        this.showManager = showManager;
        this.seatManager = seatManager;
    }

    // get all free seats of a theatre id , screen id and show id
    public List<Seat> getAllFreeSeats( int showId , int theatreId , int screenId ) {

        Show show = showManager.getShowById(showId);
        List<Seat> lockedSeats = iLockProvider.getLockedSeats(show) == null ? new ArrayList<>() : iLockProvider.getLockedSeats(show) ;
        Set<Seat> bookedSeats = seatManager.getAllBookedSeats(show) == null ? new HashSet<>() : seatManager.getAllBookedSeats(show) ;
        List<Seat> allSeatOfAScreen = theatreManager.getAllShowsOfTheatreScreen( theatreId , screenId );

        return allSeatOfAScreen.stream()
                .filter(seat -> !lockedSeats.contains(seat) && !bookedSeats.contains(seat))
                .toList();
    }

    // create booking

    public void createBooking(int showId , List<Seat> seatsToBook  , User user)  {

        Show show = showManager.getShowById(showId);

        // lock the seats first
        iLockProvider.lockSeats(show , seatsToBook  , user );

        // after locking the seats , we can proceed to book the seats
        Set<Seat> alreadyBookedSeats = seatManager.getAllBookedSeats(show) == null ? new HashSet<>() : seatManager.getAllBookedSeats(show) ;

        // check if any of the seats are already booked
        for( Seat seat : seatsToBook )
        {
            if( alreadyBookedSeats.contains(seat) && iLockProvider.isSeatLockeForThisShow(show , seat) )
            {
                System.out.println("Seat " + seat.getSeatNumber() + " is already booked / locked for the show " + show.getShowId());
                return; // not allowing partial booking
            }
        }

        System.out.println("Successfully locked seats for show , no other can book these now . Pay to Confirm !! " + show.getShowId());

    }

    // confirm and release the lock
    public void confirmBooking( int showId , List<Seat> seatsToBook  , User user , PaymentStrategy paymentStrategy)  {
        Show show = showManager.getShowById(showId);

        // process the payment

        Double amt = 0.0;
        for( Seat seat : seatsToBook )
        {
         amt += seat.getSeatType() == SEAT_TYPE.REGULAR ? 100.0 : 200.0;
        }

        paymentStrategy.pay(amt);

        // book the seats
        for( Seat seat : seatsToBook )
        {
            seatManager.bookSeats(show , seat );
            System.out.println("Successfully booked seat " + seat.getSeatId());
        }

        // release the locks
        iLockProvider.unlockSeats(show , seatsToBook , user );

        System.out.println("Successfully booked seats for show : " + show.getShowId());
    }

}
