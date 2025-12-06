package Car_Rental_Zoom_Car.Service.VehicleService;

import Car_Rental_Zoom_Car.Entities.*;

public class Car extends Vehicle {

    Car( int registrationNumber, String color, VehicleStatusEnum status, Double basePrice,
            VehicleEnum vehicleType )
    {
        super(registrationNumber, color, status, basePrice, vehicleType);
    }
	

    @Override
    public int calcBasePrice( int days )
    {
        return 20*days;
    }
}
