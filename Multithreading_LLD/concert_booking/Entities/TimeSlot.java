package Multithreading_LLD.concert_booking.Entities;

import java.sql.Time;
import java.time.LocalDateTime;

public class TimeSlot {

    // for one Slot what is the start time and end time
    public LocalDateTime startHour;
    public LocalDateTime endHour;
    public TimeSlot( LocalDateTime start , LocalDateTime end)
    {
        this.startHour = start;
        this.endHour = end;
    }



}
