package ParkingLot.observer.subscriber;

import ParkingLot.Entities.User;

public interface ChannelInterface {

    // update method
    public void notify( String message , User user);
    
}
