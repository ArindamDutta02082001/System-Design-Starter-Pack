package Multithreading_LLD.concert_booking.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

public class ShowSlot {

//    LocalDateTime startHour;
//    LocalDateTime endHour;    // --> creating another entity

    public TimeSlot timeSlot;
    int capacity = 5; // HARD CODING for now
    int countOfBooking=0;
    Deque<User> waitList = new ArrayDeque<>();

    // utility functions to book this slot

    boolean isOverlap( TimeSlot newSlot )
    {
        if( newSlot.startHour.isAfter(timeSlot.startHour) && newSlot.endHour.isBefore(timeSlot.endHour))
            return true;

        return false;
    }

    public void addToWaitList(User u)
    {
        waitList.add(u);
    }






}
