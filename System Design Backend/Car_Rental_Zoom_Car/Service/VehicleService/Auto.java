package Car_Rental_Zoom_Car.Service.VehicleService;

import Car_Rental_Zoom_Car.Entities.Vehicle;
import Car_Rental_Zoom_Car.Entities.VehicleEnum;
import Car_Rental_Zoom_Car.Entities.VehicleStatusEnum;

public class Auto extends Vehicle {

    Auto( int registrationNumber, String color, VehicleStatusEnum status, Double basePrice,
            VehicleEnum vehicleType )
    {
        super(registrationNumber, color, status, basePrice, vehicleType);
    }
	

    @Override
    public int calcBasePrice( int days )
    {
        return 10*days;
    }
}
