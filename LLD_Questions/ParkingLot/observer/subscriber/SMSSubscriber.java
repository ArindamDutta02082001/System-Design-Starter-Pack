package ParkingLot.observer.subscriber;

import ParkingLot.Entities.User;

public class SMSSubscriber implements SubscriberInterface {

    User user;
    public SMSSubscriber( User user )
    {
        this.user = user;
    }

    @Override
    public void update( String message , User user) {
        System.out.println("SMS Notification is sent to mobile: "+user.mobile+" of user :"+user.name+" message : "+message);
    }

    @Override
    public User getUser() {
        return this.user;
    }
    
}
