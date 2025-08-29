package ParkingLot.Entities;

import java.time.Duration;
import java.time.LocalDateTime;


public class Ticket {
    
    // Attributes
    public String ticketNo;
    public LocalDateTime entryTime;
    public LocalDateTime exitTime;
    // public String parkingLotName;
    // public String parkingSpotId;
    public Vehicle vehicle;
    public User user;

    // constructor
    public Ticket( String ticketNo , LocalDateTime entryTime , User user , Vehicle vehicle )   
    {
        this.ticketNo = ticketNo;
        this.entryTime = entryTime;
        this.user = user;
        this.vehicle = vehicle;
    }

    // method to set exit time when vehicle leaves the parking lot
    public void setExitTime( LocalDateTime exitTime )
    {
        this.exitTime = exitTime;
    }

    // method to get the duration of parking in hours
    public long getParkingDurationInHours()
    {
        long duration = Duration.between(exitTime, entryTime).toMillis();  // duration in milliseconds
        return duration / (1000 * 60 * 60);
    }

    // set entry time
    public void setEntryTime( LocalDateTime entryTime )  
    {
        this.entryTime = entryTime;
    }
}
