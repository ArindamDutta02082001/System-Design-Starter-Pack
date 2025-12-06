package ParkingLot.strategy.spotfinder;

import java.util.Map;

import ParkingLot.Entities.Floor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.factory.VehicleTypeEnum;

public class BestFitStrategy implements SpotFinder {

    @Override
    public ParkingSpot findSpot( Map<Integer,Floor> floors , VehicleTypeEnum vehicleType ) {
       
        ParkingSpot bestSpot = null;
        int minSpaceLeft = Integer.MAX_VALUE;

        for( Floor floor : floors.values() )
        {
            for( ParkingSpot spot : floor.parkingSpots)
            {
                if( spot.isAvailable && spot.spotType.getPriority() >= vehicleType.getPriority() )
                {
                    int spaceLeft = spot.spotType.getPriority() - vehicleType.getPriority();
                    if( spaceLeft < minSpaceLeft )
                    {
                        minSpaceLeft = spaceLeft;
                        bestSpot = spot;
                    }
                }
            }
        }

        return bestSpot;
    }
    
}
