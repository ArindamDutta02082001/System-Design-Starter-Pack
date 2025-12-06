package ParkingLot.Entities;

import java.util.List;

public class Floor {

    // Attributes
    public Integer floorNo;
    public List<ParkingSpot> parkingSpots;

    // constructor
    public Floor(Integer floorNo , List<ParkingSpot> parkingSpots )
    {
        this.floorNo = floorNo;
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


    // as per the requriement not hardcoding here , rather using strategy pattern to find spot
    
    // // finding an available parking spot in this floor
    // public ParkingSpot getAvailableSpot( )
    // {
    //     for( ParkingSpot spot : parkingSpots )
    //     {
    //         if( spot.isAvailable == true )
    //         {
    //             return spot;
    //         }
    //     }
    //     return null; // no spot available
    // }
}
