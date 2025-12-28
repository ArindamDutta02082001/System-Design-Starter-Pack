package com.lld.notification.entities;



import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.publisher.Subject;
import com.lld.notification.observer.subscriber.Observerr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Topic  implements Subject {


    public TOPIC_ENUMS TOPICENUMS;



    // list of subscribers
    List<Observerr> subscriberList;


    public Topic( TOPIC_ENUMS TOPICENUMS)
    {
        this.TOPICENUMS = TOPICENUMS;
        this.subscriberList = new ArrayList<>();
    }



    // subscribe and unsubscribe from a topic

    @Override
    public void registerObserver( Observerr s)
    {
        subscriberList.add(s);
        System.out.println(s.name+ " Subscribed to : "+ TOPICENUMS.toString());
    }

    @Override
    public void unregisterObserver( Observerr s)
    {
        subscriberList.remove(s);
        System.out.println(s.name+ " Unsubscribed to : "+ TOPICENUMS.toString());
    }


    @Override
    public void  notifyObservers( MessageDto message )
    {
        for( Observerr s : subscriberList )  {
            s.update(message, TOPICENUMS);
        }
    }

    public void addMessageToTopic( MessageDto messageDto )
    {
        notifyObservers(messageDto);
    }



    
}
