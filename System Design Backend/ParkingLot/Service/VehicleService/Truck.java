package ParkingLot.Service.VehicleService;

import ParkingLot.Entities.*;

public class Truck extends Vehicle {

    Truck( String licenseNo,  VehicleTypeEnum type, String color ) 
    {
        super(licenseNo, type, color);
    }
}

