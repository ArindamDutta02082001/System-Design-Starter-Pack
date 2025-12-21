package ObserverPattern.PubSub.observer.subscriber;

import ObserverPattern.PubSub.entities.MessageDto;

public abstract class Observerr {

    public String name;

    public Observerr( String name )
    {
        this.name=name;
    }
    public abstract void update(MessageDto mssg);
}
