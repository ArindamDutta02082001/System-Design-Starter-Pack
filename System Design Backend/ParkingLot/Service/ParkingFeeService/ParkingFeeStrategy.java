package ParkingLot.Service.ParkingFeeService;

import ParkingLot.Entities.VehicleTypeEnum;

public interface ParkingFeeStrategy {

    public Double calc( VehicleTypeEnum vehicleTypeEnum , long durationInMin );
    
}
