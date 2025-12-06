package ParkingLot.factory;


public class Vehicle {

    // Attributes
    public String licenseNo;
    public VehicleTypeEnum vehicleType;    

    // constructor
    public Vehicle( String licenseNo , VehicleTypeEnum vehicleType  )
    {
        this.licenseNo = licenseNo;
        this.vehicleType = vehicleType;
    }
    
    
}



