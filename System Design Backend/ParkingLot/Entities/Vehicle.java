package ParkingLot.Entities;

public class Vehicle {

    // Attributes
    public String licenseNo;
    public VehicleTypeEnum vehicleType;    
    public String color;

    // constructor
    public Vehicle( String licenseNo , VehicleTypeEnum vehicleType , String color )
    {
        this.licenseNo = licenseNo;
        this.vehicleType = vehicleType;
        this.color = color;
    }
    
    
}



