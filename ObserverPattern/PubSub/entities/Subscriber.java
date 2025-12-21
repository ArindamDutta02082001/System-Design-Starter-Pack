package ObserverPattern.PubSub.entities;

import ObserverPattern.PubSub.entities.MessageDto;
import ObserverPattern.PubSub.observer.subscriber.Observerr;

public class Subscriber extends Observerr {

    public String name;

    public Subscriber( String name )
    {
        super(name);
    }

    // update fn

    @Override
    public void update(MessageDto message )
    {
        System.out.println( "[INCOMING] "+message.messageString+" timestamp : "+message.timeStamp.toString()+" - "+name);
    }

}
