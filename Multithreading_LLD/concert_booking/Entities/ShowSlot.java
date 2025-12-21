package Multithreading_LLD.concert_booking.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

public class ShowSlot  impl{

//    LocalDateTime startHour;
//    LocalDateTime endHour;    // --> creating another entity

    public TimeSlot timeSlot;
    int bookingCount=0;
    int maxBookingCapacity;


    // a waitlist feature for the current slot
    Deque<User> waitList = new ArrayDeque<>();

    public synchronized boolean bookCurrentSlot( LocalDateTime startTime , User u)
    {

        if(isSlotAvaliable(startTime))
            bookingCount +=1;
        else
        {
            // add to the wait list
            waitList.add(u);
            return false;
        }

        return true;
    }

    public synchronized void cancelBooking( User u)
    {
        if( bookingCount >0 )
            bookingCount -=1;

        // check if waitlist has any user
        if( !waitList.isEmpty() )
        {
            User nextUser = waitList.poll();
            // book for this user
            bookingCount +=1;
            // notify user

            System.out.println("Notifying user "+ nextUser.userid + " for booking in slot "+ timeSlot.startHour);
        }
    }

    public ShowSlot(TimeSlot timeSlot , int slotCapacity) {
        this.timeSlot = timeSlot;
        this.maxBookingCapacity = slotCapacity;
    }

    // utility functions to book this slot

    boolean isOverlapForCurrentSlot( TimeSlot newSlot )
    {
        if( newSlot.startHour.isAfter(timeSlot.startHour) && newSlot.endHour.isBefore(timeSlot.endHour))
            return true;

        return false;
    }

    public boolean isSlotAvaliable( LocalDateTime time)
    {
        return bookingCount < maxBookingCapacity;
    }






}
