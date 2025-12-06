package ParkingLot.factory;


import ParkingLot.Entities.*;

public class Car extends Vehicle {

    Car( String licenseNo,  VehicleTypeEnum type ) 
    {
        super(licenseNo, type);
    }
}
