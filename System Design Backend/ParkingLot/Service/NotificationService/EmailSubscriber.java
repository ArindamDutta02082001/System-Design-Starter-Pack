package ParkingLot.Service.NotificationService;

import ParkingLot.Entities.User;

public class EmailSubscriber implements SubscriberInterface {

    String email;
    public EmailSubscriber( String email )
    {
        this.email = email;
    }

     @Override
    public void update( String message, User user) {
        System.out.println("Emai Notification  sent to : "+this.email+" with message : "+message);
    }
}
