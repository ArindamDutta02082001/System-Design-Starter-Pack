package Multithreading_LLD.concert_booking;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.ShowSlot;
import Multithreading_LLD.concert_booking.Entities.TimeSlot;
import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.Entities.enums.Genre;
import Multithreading_LLD.concert_booking.observer.subsriber.EmailChannel;
import Multithreading_LLD.concert_booking.observer.subsriber.IChannel;
import Multithreading_LLD.concert_booking.observer.subsriber.MobileChannel;
import Multithreading_LLD.concert_booking.strategy.ranking.GenreStrategy;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.nio.channels.Channel;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main( String[] args ) throws InterruptedException {

        // **************** actors ***************

        BookingManager bm = new BookingManager();

        // creating LiveShows

        // we will have 2 Live shows  ,
        // for Show1 4 ShowSlots from   6am-7am , 9-10am , 12pm-1pm , 3-4pm
        // for Show2 4 ShowSlots from  7am-8am , 9-10am , 10pm-11pm , 12-1pm

        // creating timeSLots first (will be common used)
        TimeSlot t1 = new TimeSlot(LocalDateTime.of(2025,8,2,6,0) ,LocalDateTime.of(2025,8,2,7,0)  );
        TimeSlot t2 = new TimeSlot(LocalDateTime.of(2025,8,2,7,0) ,LocalDateTime.of(2025,8,2,8,0)  );
        TimeSlot t3 = new TimeSlot(LocalDateTime.of(2025,8,2,8,0) ,LocalDateTime.of(2025,8,2,9,0)  );
        TimeSlot t4 = new TimeSlot(LocalDateTime.of(2025,8,2,9,0) ,LocalDateTime.of(2025,8,2,10,0)  );
        TimeSlot t5 = new TimeSlot(LocalDateTime.of(2025,8,2,10,0) ,LocalDateTime.of(2025,8,2,11,0)  );
        TimeSlot t6 = new TimeSlot(LocalDateTime.of(2025,8,2,11,0) ,LocalDateTime.of(2025,8,2,12,0)  );
        TimeSlot t7 = new TimeSlot(LocalDateTime.of(2025,8,2,12,0) ,LocalDateTime.of(2025,8,2,13,0)  );
        TimeSlot t8 = new TimeSlot(LocalDateTime.of(2025,8,2,15,0) ,LocalDateTime.of(2025,8,2,16,0)  );


        LiveShow liveShow1 = new LiveShow("TMKOC" , Genre.COMEDY);

        // add a show slot for a show
        ShowSlot s1 = new ShowSlot(t1,2);
        ShowSlot s2 = new ShowSlot(t3,2);
        ShowSlot s3 = new ShowSlot(t7,2);
        ShowSlot s4 = new ShowSlot(t8,2);


        liveShow1.addShowSlot(s1);
//        liveShow1.addShowSlot(s1);  // will throw exception  if un
        liveShow1.addShowSlot(s2);
        liveShow1.addShowSlot(s3);
        liveShow1.addShowSlot(s4);


        LiveShow liveShow2 = new LiveShow("Anshuman_Comedy" , Genre.COMEDY);
        ShowSlot s5 = new ShowSlot(t2,2);
        ShowSlot s6 = new ShowSlot(t3,2);
        ShowSlot s7 = new ShowSlot(t5,2);
        ShowSlot s8 = new ShowSlot(t7,2);


        liveShow2.addShowSlot(s5);
        liveShow2.addShowSlot(s6);
        liveShow2.addShowSlot(s7);
        liveShow2.addShowSlot(s8);

        bm.addShows(liveShow1);
        bm.addShows(liveShow2);

        // user creating

        // creating channel for user 1
        IChannel ch1User1 = new MobileChannel();
        IChannel ch2User1 = new EmailChannel();


        User user1 = new User("user_1" , "12345634" , "user1@email" );
        user1.preferredChannels.add(ch1User1);
        user1.preferredChannels.add(ch2User1);

        IChannel ch1User2 = new MobileChannel();
        User user2 = new User("user_2" , "12sdfg34" , "user2@email" );
        user2.preferredChannels.add(ch1User2);

        // ******** actions

        // user login
        bm.login(user1);
        bm.login(user2);

        // non login do----

        // see the shows
        RankingStrategy rs = new GenreStrategy(Genre.COMEDY);
        bm.selectAndSearchByStrategy(rs);




        // user 1 booking 2 tickets for LiveShow1
        bm.book(user1,"TMKOC" ,
                LocalDateTime.of(2025,8,2,8,1) ,2);
        System.out.println("***********************  delimiter ********************** ");


        // should give house full
        bm.book(user2,"TMKOC" ,
                LocalDateTime.of(2025,8,2,8,1) ,2);
        System.out.println("***********************  delimiter ********************** ");


        // should show already booked in the interval of 8-9am
        bm.book(user1,"Anshuman_Comedy" ,
                LocalDateTime.of(2025,8,2,8,1) ,2);

        System.out.println("***********************  delimiter ********************** ");


        // user1 cancel 1 seat , so user2 should get 1 seat booked
        bm.cancel(user1,"TMKOC" ,
                LocalDateTime.of(2025,8,2,8,1) ,1);

        System.out.println("***********************  delimiter ********************** ");


        // stimulate concurrency check to book same slot all
        Runnable booking1 = ()->{
            bm.book(user1,"Anshuman_Comedy" ,
                    LocalDateTime.of(2025,8,2,12,1) ,2);
        };
        Runnable booking2 = ()->{
            bm.book(user2,"Anshuman_Comedy" ,
                    LocalDateTime.of(2025,8,2,12,1) ,2);
        };
        Thread thread1 = new Thread(booking1);
        Thread thread2 = new Thread(booking2);

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();

    }
}
