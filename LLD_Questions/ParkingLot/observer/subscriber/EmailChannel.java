package ParkingLot.observer.subscriber;

import ParkingLot.Entities.User;

public class EmailChannel implements ChannelInterface {

    @Override
    public void notify( String message , User user) {
        System.out.println("Emai Notification  sent to : "+user.email+" of user :"+user.name+" with message : "+message);
    }
    
}
