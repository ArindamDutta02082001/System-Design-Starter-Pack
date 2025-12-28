package ObserverPattern.PubSub.observer.subscriber;

import ObserverPattern.PubSub.entities.MessageDto;
import ObserverPattern.PubSub.entities.TopicEnum;

public abstract class Observerr {

    public String name;

    public Observerr( String name )
    {
        this.name=name;
    }
    public abstract void update(MessageDto mssg , TopicEnum topicEnum);
}
