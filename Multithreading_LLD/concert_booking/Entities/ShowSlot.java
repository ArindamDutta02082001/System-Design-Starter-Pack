package Multithreading_LLD.concert_booking.Entities;

import Multithreading_LLD.concert_booking.observer.publisher.Publisher;
import Multithreading_LLD.concert_booking.observer.subsriber.Subscriber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShowSlot  implements Publisher {

//    LocalDateTime startHour;
//    LocalDateTime endHour;    // --> creating another entity

    public TimeSlot timeSlot;
    int bookingCount=0;
    int maxBookingCapacity;


    // for observer subscriber storage
    List<Subscriber> listOfSubs;


    // a wait list feature for the current slot
    Deque<User> waitList;

    public ShowSlot(TimeSlot timeSlot , int slotCapacity) {
        this.timeSlot = timeSlot;
        this.maxBookingCapacity = slotCapacity;
        this.waitList = new ArrayDeque<>();
        this.listOfSubs = new ArrayList<>();
    }

    // accept a single booking of n person for user u and return total seats booked
    public  synchronized  int bookCurrentSlot( LocalDateTime time  , User u , int person)  {
       int avaiableSeats =  maxBookingCapacity-bookingCount;

        if(time.isAfter(timeSlot.startHour) && time.isBefore(timeSlot.endHour)) {

            if (person <= avaiableSeats)  // validation logic
            {
                bookingCount += person;
                u.bookUserSlot(timeSlot);

                notifySubscribers(u , "Your "+person+" seat/s was booked for slot : "+timeSlot.startHour);
                return person;
            } else if (avaiableSeats != 0)  // thoda seat hi book h pyega
            {
                bookingCount -= avaiableSeats;
                person -= avaiableSeats;
                while (person-- > 0) {
                    waitList.add(u);
                }
                notifySubscribers(u , "Your "+avaiableSeats+" seat/s was booked for slot : "+timeSlot.startHour);
                return avaiableSeats;
            } else {
                // add to the wait list
                while (person-- > 0) {
                    waitList.add(u);
                }

                System.out.println(u.userid + " is added to waitList , for Slot : " + timeSlot.startHour.getHour() + " HouseFull !!");
                notifySubscribers(u , "Your "+0+" seat/s was booked for slot : "+timeSlot.startHour);
                return 0;

            }
        }
        return 0;

    }

    public synchronized boolean cancelBooking( User u , LocalDateTime time , int persons)
    {
        if( bookingCount >0 &&
                (time.isAfter(timeSlot.startHour) && time.isBefore(timeSlot.endHour)
                        || time.isEqual(timeSlot.startHour) && time.isEqual(timeSlot.endHour)) ) {
            bookingCount -= persons;
            u.removeUserSlot(timeSlot);
            notifySubscribers(u , u.userid+"`s "+persons+" seat/s was cancelled for slot : "+timeSlot.startHour);
        }
        else
            return false;

        // check if wait list has any user
        if( !waitList.isEmpty() && persons-->0 )
        {
            User nextUser = waitList.poll();
            nextUser.bookUserSlot(timeSlot);
            // notify user
            notifySubscribers(nextUser , nextUser.userid+" seat is booked for slot : "+timeSlot.startHour);

            // book for this user
            bookingCount +=1;
            return true;

        }

        return true;
    }

    // utility functions to book this slot

    boolean isOverlapForCurrentSlot( TimeSlot newSlot )
    {
        if( newSlot.startHour.isAfter(timeSlot.startHour) && newSlot.endHour.isBefore(timeSlot.endHour))
            return true;

        return false;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        listOfSubs.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        listOfSubs.remove(subscriber);
    }

    @Override
    public void notifySubscribers(User u , String message) {
//        for()  // not notifying all the users
        u.update(message);
    }
}
