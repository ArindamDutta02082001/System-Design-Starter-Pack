package ParkingLot.Entities;

import java.util.List;

public class ParkingFloor {

    // Attributes
    public String floorId;  
    public List<ParkingSpot> parkingSpots;

    // constructor
    public ParkingFloor( String floorId , List<ParkingSpot> parkingSpots )
    {
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }
    

    // If after assigning a parking spot to a vehicle, we want to add or remove a parking spot from the floor
    
    // add a new parking spot
    public void addParkingSpot( ParkingSpot spot )
    {
        parkingSpots.add( spot );
    }

    // remove a parking spot
    public void removeParkingSpot( ParkingSpot spot )
    {
        parkingSpots.remove( spot );
    }
}
