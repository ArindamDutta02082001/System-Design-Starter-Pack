package Car_Rental_Zoom_Car.Service.VehicleService;

import Car_Rental_Zoom_Car.Entities.Vehicle;
import Car_Rental_Zoom_Car.Entities.VehicleEnum;
import Car_Rental_Zoom_Car.Entities.VehicleStatusEnum;

public class VehicleFactory {

  
    // you have to create a static function that will return object based on the type
    public static Vehicle createVehicle(int registrationNumber, String color, VehicleStatusEnum status, Double basePrice,
            VehicleEnum vehicleType  )
    {
        switch (vehicleType) {

            case AUTO :
                return new Auto(registrationNumber, color, status, basePrice, vehicleType);
            case CAR :
                return new Car(registrationNumber, color, status, basePrice, vehicleType);
            case TRUCK :
                return new Truck(registrationNumber, color, status, basePrice, vehicleType);
            case TWOWHEELER :
                return new Bike(registrationNumber, color, status, basePrice, vehicleType);
        
            default:
               return null;
        }
    }

    
}
