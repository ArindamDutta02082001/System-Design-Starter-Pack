package ParkingLot.observer.publisher;

import java.util.*;

import ParkingLot.Entities.User;
import ParkingLot.observer.subscriber.SubscriberInterface;

public class Publisher {

    List<SubscriberInterface> subscribers;

    public Publisher()
    {
        this.subscribers = new ArrayList<>();
    }


    public void subscribe( SubscriberInterface subscriber )
    {
        this.subscribers.add( subscriber );
    }

    public void unsubscribe( SubscriberInterface subscriber )
    {
        this.subscribers.remove( subscriber );
    }

    public void notifySubscribers(  User user , String message)
    {
        for( SubscriberInterface subscriber : this.subscribers )
        {
            User subUser = subscriber.getUser();
            if( subUser != null && subUser.name.equals(user.name))
            {
                subscriber.update( message , user);
            }
        }
    }


    
}
