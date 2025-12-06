package ParkingLot.strategy.spotfinder;

import java.util.Map;

import ParkingLot.Entities.Floor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.factory.VehicleTypeEnum;

public class FirstSpotStrategy implements SpotFinder {

    @Override
    public ParkingSpot findSpot( Map<Integer,Floor> floors , VehicleTypeEnum vehicleType ) {
        
        for( Integer floorNo : floors.keySet() )
        {
            Floor floor = floors.get(floorNo);
            for( ParkingSpot spot : floor.parkingSpots )
            {
                if( spot.isAvailable && spot.spotType.getPriority() >= vehicleType.getPriority() )
                {
                    return spot;
                }
            }
        }

        return null;
    }
    
}
