package Multithreading_LLD.concert_booking.observer.publisher;

import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.observer.subsriber.Subscriber;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(User u , String message);
}
