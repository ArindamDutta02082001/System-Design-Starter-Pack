package ParkingLot.strategy.parkingfee;

import ParkingLot.factory.VehicleTypeEnum;

public class BasicHourFeeStrategy implements ParkingFee {

    @Override
    public Double calc( VehicleTypeEnum vehicleTypeEnum , long durationInHour ) {

        
        Double fee = 0.0;

        switch( vehicleTypeEnum )
        {
            case TWOWHEELER:
                fee = durationInHour * 1.0;
                break;

            case AUTO:
                fee = durationInHour * 2.0;
                break;

            case CAR:
                fee = durationInHour * 3.0;
                break;

            case TRUCK:
                fee = durationInHour * 4.0;
                break;

            default:
                fee = durationInHour * 5.0;
                break;
        }

        return fee;
    }


    
}
