package Multithreading_LLD.concert_booking.Entities;

import Multithreading_LLD.concert_booking.Entities.enums.Genre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LiveShow {

    public String name;

    // taking 2 attr as of now , ise basis pe show sort hinge
    public Genre genre;
    int bookingCount;  // for popularity

    // this show will be available in this time slot
    List<ShowSlot> allSlots;

    /**
     * ShowSlot	WHAT happens at that time for a show
     */

    public LiveShow(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
        this.allSlots = new ArrayList<>();
    }


    // user methods
    public List<ShowSlot> getSlots() {
        return allSlots;
    }

    // admin methods

    // Prevent overlapping slots for same show
    public void addShowSlot(ShowSlot slot) {
        for (ShowSlot s : allSlots) {
            if ( slot.isOverlapForCurrentSlot(slot.timeSlot) ){
                throw new RuntimeException("Overlapping slot not allowed for show");
            }
        }
        allSlots.add(slot);
        Collections.sort(allSlots , (ShowSlot a , ShowSlot b)->a.timeSlot.startHour.compareTo(b.timeSlot.startHour));
    }

    public int bookaSlot( User u , LocalDateTime time ,int person ) {
        for( ShowSlot s : allSlots)
        {
            if( time.isAfter(s.timeSlot.startHour) && time.isBefore(s.timeSlot.endHour))
            {
                // we can try to book only if the current time is not present in the users already booked slot
                for( TimeSlot tt : u.getBookedSlots())
                    if(time.isAfter(tt.startHour) && time.isBefore(tt.endHour)
                            || (time.isEqual(tt.startHour) || time.isEqual(tt.endHour)) )     {

                        System.out.println("User "+u.userid+" has already booking in the slot from : "+tt.startHour.getHour());
                        return 0;
                    }

                return s.bookCurrentSlot(time , u , person);
            }

        }
        return 0;
    }

    public boolean cancelaSlot( User u , LocalDateTime time , int persons)
    {
        for( ShowSlot s : allSlots)
        {
            if( time.isAfter(s.timeSlot.startHour) && time.isBefore(s.timeSlot.endHour))
                // we can try to cancel
                return s.cancelBooking(u,time , persons);

        }
        return false;
    }





}
