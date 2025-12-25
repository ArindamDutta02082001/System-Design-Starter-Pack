package src.strategy;

import src.Entities.OfferRide;
import src.RideManager;

public interface RideSelectionStrategy {

    public OfferRide rideSelect(RideManager rideManager , String src , String dest );
}
