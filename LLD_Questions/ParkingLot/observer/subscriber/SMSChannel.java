package ParkingLot.observer.subscriber;

import ParkingLot.Entities.User;

public class SMSChannel implements ChannelInterface {

    @Override
    public void notify( String message , User user) {
        System.out.println("SMS Notification is sent to mobile: "+user.mobile+" of user :"+user.name+" message : "+message);
    }
    
}
