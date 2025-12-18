package Multithreading_LLD.concert_booking.Entities;

import Multithreading_LLD.concert_booking.Entities.enums.Genre;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LiveShow {

    public String name;

    // taking 2 attr as of now , ise basis pe show sort hinge
    public Genre genre;
    int bookingCount;

    // this show will be available in this time slot
    List<ShowSlot> allSlots;


    /**
     * ShowSlot	WHAT happens at that time for a show
     */

    public LiveShow(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    // Prevent overlapping slots for same show
    public void addSlot(ShowSlot slot) {
        for (ShowSlot s : allSlots) {
            if ( slot.isOverlap(slot.timeSlot) ){
                throw new RuntimeException("Overlapping slot not allowed for show");
            }
        }
        allSlots.add(slot);
    }

    public List<ShowSlot> getSlots() {
        return allSlots;
    }

    public boolean isSlotAvaliable( LocalDateTime time)
    {
        ShowSlot s = allSlots.stream().filter( e->e.timeSlot.startHour.isEqual(time)).toList().getFirst();
        return s.countOfBooking != s.capacity;
    }

    public synchronized boolean bookSlot( LocalDateTime time , User u)
    {
        ShowSlot s = allSlots.stream().filter( e->e.timeSlot.startHour.isEqual(time)).toList().getFirst();
        if(isSlotAvaliable(time))
            s.countOfBooking +=1;
        else
        {
            // add to the wait list
            s.addToWaitList(u);
            return false;
        }

        return true;
    }


}
