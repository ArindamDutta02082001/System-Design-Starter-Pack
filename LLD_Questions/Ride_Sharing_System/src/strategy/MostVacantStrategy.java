package src.strategy;

import src.Entities.OfferRide;
import src.RideManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostVacantStrategy implements RideSelectionStrategy{
    @Override
    public OfferRide rideSelect(RideManager rideManager , String src , String dest) {
        List<OfferRide> allRides = new ArrayList<>();

        for( Integer uid : rideManager.offerRides.keySet())
        {
            List<OfferRide> temp =  rideManager.offerRides.get(uid);
            for( OfferRide or : temp )
                allRides.add(or);
        }

        Collections.sort(allRides , (OfferRide a , OfferRide b)->{
            return a.avaliable-b.avaliable;
        });

        return allRides.stream().filter((r)->{
            return r.source.equals(src) && r.destination.equals(dest) && r.vehicle.isAvaliable;
        }).toList().getFirst();
    }
}
