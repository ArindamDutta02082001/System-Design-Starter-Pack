package ParkingLot.Service.ParkingFeeService;

public class PremiumMinuteFee implements ParkingFeeStrategy {

    @Override
    public Double calc( ParkingLot.Entities.VehicleTypeEnum vehicleTypeEnum , long durationInMin ) {
        
        Double fee = 0.0;

        switch( vehicleTypeEnum )
        {
            case TWOWHEELER:
                fee = durationInMin * 2.0;
                break;

            case AUTO:
                fee = durationInMin * 3.0;
                break;

            case CAR:
                fee = durationInMin * 5.0;
                break;

            case TRUCK:
                fee = durationInMin * 10.0;
                break;

            default:
                fee = 0.0;
        }

        return fee;
    }
    
}
