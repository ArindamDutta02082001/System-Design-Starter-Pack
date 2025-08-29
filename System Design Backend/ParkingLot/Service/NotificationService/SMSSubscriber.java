package ParkingLot.Service.NotificationService;

import ParkingLot.Entities.User;

public class SMSSubscriber implements SubscriberInterface {

    String phoneNumber;
    public SMSSubscriber( String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update( String message , User user) {
        System.out.println("SMS Notification is sent to mobile: "+phoneNumber+" with message : "+message);
    }
    
}
