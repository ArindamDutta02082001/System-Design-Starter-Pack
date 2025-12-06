package ParkingLot.strategy.spotfinder;

import java.util.Map;

import ParkingLot.Entities.Floor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.factory.VehicleTypeEnum;

public interface SpotFinder {

    public ParkingSpot findSpot( Map<Integer,Floor> floors , VehicleTypeEnum vehicleType );
}