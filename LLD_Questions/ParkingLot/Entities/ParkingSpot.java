package ParkingLot.Entities;


import ParkingLot.factory.Vehicle;
import ParkingLot.factory.VehicleTypeEnum;

public class ParkingSpot {


    // Attributes
    public String spotId;
    public boolean isAvailable; 

    public VehicleTypeEnum spotType;   
    public Vehicle currentVehicle;

    // constructor
    public ParkingSpot( String spotId ,  VehicleTypeEnum spotType  )
    {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true; 
    }

    // place a vehicle in the spot
    public void assignVehicle( Vehicle vehicle )
    {
        this.currentVehicle = vehicle;
        this.isAvailable = false;
    }

    // @Override
    // public String toString()
    // {
    //     System.out.println("SPOT :"+spotId+" , type : "+spotType.toString()+" free : "+isAvailable);
    //     return "";
    // }

}
