package ParkingLot.Entities;

import java.time.Duration;
import java.time.LocalDateTime;

import ParkingLot.factory.Vehicle;


public class Ticket {
    
    // Attributes
    public String ticketNo;

    public LocalDateTime entryTime;
    public LocalDateTime exitTime;

    public ParkingSpot parkingSpot;
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
        return Duration.between(exitTime, entryTime).toMillis() / 3600000;
    }

    // set entry time
    public void setEntryTime( LocalDateTime entryTime )  
    {
        this.entryTime = entryTime;
    }
}
