package com.lld.notification.observer.publisher;

import com.lld.notification.entities.MessageDto;
import com.lld.notification.observer.subscriber.Observerr;

public interface Subject {

    // methods to register and unregister observers
    public void registerObserver(Observerr o);
    public void unregisterObserver(Observerr o);
    public void notifyObservers(MessageDto m);
}
