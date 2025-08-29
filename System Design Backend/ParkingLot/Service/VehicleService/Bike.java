package ParkingLot.Service.VehicleService;

import ParkingLot.Entities.*;

public class Bike extends Vehicle {

    Bike( String licenseNo,  VehicleTypeEnum type, String color ) 
    {
        super(licenseNo, type, color);
    }



    public void print()
    {
    System.out.println(this.licenseNo);
    }
}
