package ObserverPattern.PubSub.subscriber;

import ObserverPattern.PubSub.entities.MessageDto;

public class Subscriber {

    public String name;

    public Subscriber( String name )
    {
        this.name = name;
    }

    // update fn

    public void update(MessageDto message )
    {
        System.out.println( "[INCOMIG] "+message.messageString+" timestamp : "+message.timeStamp.toString()+" - "+name);
    }
    
}
