package Multithreading_LLD.movie_booking.Entities;

import Multithreading_LLD.movie_booking.Entities.enums.Genre;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class Event {

    public String name;

    // taking 2 attr as of now , ise basis pe show sort hinge
    public Genre genre;
    LocalDateTime firstShow;

    // this show will be available in this time slot
    Map<Slot , ShowSlot> allSlots;


    /**
     * Concept	Represents
     * TimeSlot	WHEN (pure time)
     * ShowSlot	WHAT happens at that time for a show
     */


}
