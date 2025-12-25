package src.strategy;

import src.Entities.OfferRide;
import src.RideManager;

import java.util.ArrayList;
import java.util.List;

public class PreferredVehicleStrategy implements RideSelectionStrategy{

    String vname;
    public PreferredVehicleStrategy( String vname )
    {
        this.vname =vname;
    }
    @Override
    public OfferRide rideSelect(RideManager rideManager , String src , String dest) {
        List<OfferRide> allRides = new ArrayList<>();

        for( Integer uid : rideManager.offerRides.keySet())
        {
            List<OfferRide> temp =  rideManager.offerRides.get(uid);
            for( OfferRide or : temp )
            {
                if(or.vehicle.vname.equals(this.vname) && or.source.equals(src) && or.destination.equals(dest))
                    return or;
            }
        }
        return null;

    }
}
