package ObserverPattern.PubSub.entities;

import ObserverPattern.PubSub.entities.MessageDto;
import ObserverPattern.PubSub.observer.subscriber.Observerr;

import java.util.Observer;

public class Subscriber extends Observerr {

    public Subscriber( String name )
    {
        super(name);
    }

    // update fn

    @Override
    public void update(MessageDto message , TopicEnum topicEnum )
    {
        System.out.println( "[INCOMING] "+" - "+this.name+" - "+topicEnum.toString()+" - "+message.messageString+" timestamp : "+message.timeStamp.toString());
    }



}
