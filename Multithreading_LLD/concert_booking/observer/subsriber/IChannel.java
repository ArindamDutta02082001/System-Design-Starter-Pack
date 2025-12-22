package Multithreading_LLD.concert_booking.observer.subsriber;

import Multithreading_LLD.concert_booking.Entities.User;

public interface IChannel {

    public void notify(User user , String message);
}
