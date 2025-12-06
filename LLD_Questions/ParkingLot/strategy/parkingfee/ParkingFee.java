package ParkingLot.strategy.parkingfee;

import ParkingLot.factory.VehicleTypeEnum;

public interface ParkingFee {

    public Double calc( VehicleTypeEnum vehicleTypeEnum , long durationInHour );
    
}
