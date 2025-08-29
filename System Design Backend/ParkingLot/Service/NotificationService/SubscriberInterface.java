package ParkingLot.Service.NotificationService;

import ParkingLot.Entities.User;

public interface SubscriberInterface {

    // update method
    public void update( String message , User user);
    
}
