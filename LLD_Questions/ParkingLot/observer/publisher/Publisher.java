package ParkingLot.observer.publisher;

import ParkingLot.Entities.User;
import ParkingLot.observer.subscriber.ChannelInterface;
import ParkingLot.observer.subscriber.Subscriber;

public interface Publisher {


    public void subscribe( Subscriber subscriber );

    public void unsubscribe( Subscriber subscriber );

    public void notifySubscribers(  User user , String message);


    
}
