package ParkingLot.factory;

import ParkingLot.Entities.*;

public class VehicleFactory {

  
    // you have to create a static function that will return object based on the type
    public static Vehicle createVehicle( String licenseNo, VehicleTypeEnum type ) 
     {
         switch(type)
         {
             case CAR:
                 return new Car( licenseNo, type);
             case BIKE:
                 return new Bike( licenseNo, type);
             case TRUCK:
                 return new Truck( licenseNo, type);
             case AUTO:
                 return new Auto( licenseNo, type);
             default:
                 return null;
         }
    }

    
}
