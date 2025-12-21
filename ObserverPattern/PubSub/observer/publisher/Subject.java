package ObserverPattern.PubSub.observer.publisher;


import ObserverPattern.PubSub.entities.MessageDto;
import ObserverPattern.PubSub.observer.subscriber.Observerr;

public interface Subject {

    // methods to register and unregister observers
    public void registerObserver(Observerr o);
    public void unregisterObserver(Observerr o);
    public void notifyObservers(MessageDto m);
}
