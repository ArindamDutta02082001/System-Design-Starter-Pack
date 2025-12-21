package Multithreading_LLD.concert_booking.repository;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.ShowSlot;
import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class IBookingManagerImpl implements IBookingManager {

    @Override
    public void book(User user, LiveShow liveShow , LocalDateTime time) {

        // check if the slot at that time is there , if there capacity is there
        if( liveShow.bookSlot(time,user))
            System.out.println("Slot from :"+time.getHour()+" is booked for the user"+user.userid);
    }

    @Override
    public void cancel(User user, LiveShow l) {
        // not implemented
    }




}
