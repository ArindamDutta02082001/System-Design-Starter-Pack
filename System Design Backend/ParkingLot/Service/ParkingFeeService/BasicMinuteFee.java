package ParkingLot.Service.ParkingFeeService;

public class BasicMinuteFee implements ParkingFeeStrategy {

    @Override
    public Double calc( ParkingLot.Entities.VehicleTypeEnum vehicleTypeEnum , long durationInMin ) {
        
        Double fee = 0.0;

        switch( vehicleTypeEnum )
        {
            case TWOWHEELER:
                fee = durationInMin * 1.0;
                break;

            case AUTO:
                fee = durationInMin * 2.0;
                break;

            case CAR:
                fee = durationInMin * 3.0;
                break;

            case TRUCK:
                fee = durationInMin * 4.0;
                break;

            default:
                fee = durationInMin * 5.0;
                break;
        }

        return fee;
    }


    
}
