package ParkingLot.Entities;

public class ParkingSpot {


    // Attributes
    public String spotId;
    public VehicleTypeEnum spotType;   
    public boolean isAvailable; 

    // constructor
    public ParkingSpot( String spotId , VehicleTypeEnum spotType )
    {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true; 
    }

    // @Override
    // public String toString()
    // {
    //     System.out.println("SPOT :"+spotId+" , type : "+spotType.toString()+" free : "+isAvailable);
    //     return "";
    // }

}
