package ParkingLot.Service.VehicleService;


import ParkingLot.Entities.*;

public class Car extends Vehicle {

    Car( String licenseNo,  VehicleTypeEnum type, String color ) 
    {
        super(licenseNo, type, color);
    }
}
