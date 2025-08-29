package ParkingLot.Service.VehicleService;

import ParkingLot.Entities.*;

public class VehicleFactory {

  
    // you have to create a static function that will return object based on the type
    public static Vehicle createVehicle( String licenseNo, VehicleTypeEnum type, String color ) 
     {
         switch(type)
         {
             case CAR:
                 return new Car( licenseNo, type, color);
             case BIKE:
                 return new Bike( licenseNo, type, color);
             case TRUCK:
                 return new Truck( licenseNo, type, color);
             case AUTO:
                 return new Auto( licenseNo, type, color);
             default:
                 return null;
         }
    }

    
}
