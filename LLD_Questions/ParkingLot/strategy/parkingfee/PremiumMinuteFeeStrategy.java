package ParkingLot.strategy.parkingfee;

import ParkingLot.factory.VehicleTypeEnum;

public class PremiumMinuteFeeStrategy implements ParkingFee {

    @Override
    public Double calc( VehicleTypeEnum vehicleTypeEnum , long durationInHour ) {
        
        Double fee = 0.0;

        switch( vehicleTypeEnum )
        {
            case TWOWHEELER:
                fee = durationInHour * 2.0;
                break;

            case AUTO:
                fee = durationInHour * 3.0;
                break;

            case CAR:
                fee = durationInHour * 5.0;
                break;

            case TRUCK:
                fee = durationInHour * 10.0;
                break;

            default:
                fee = 0.0;
        }

        return fee;
    }
    
}
