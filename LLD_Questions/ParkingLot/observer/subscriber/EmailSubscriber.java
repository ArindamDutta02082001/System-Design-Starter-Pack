package ParkingLot.observer.subscriber;

import ParkingLot.Entities.User;

public class EmailSubscriber implements SubscriberInterface {

    User user;
    public EmailSubscriber( User user )
    {
        this.user = user;
    }

     @Override
    public void update( String message, User user) {
        System.out.println("Emai Notification  sent to : "+user.email+" of user :"+user.name+" with message : "+message);
    }

        @Override
    public User getUser() {
        return this.user;
    }
    
}
