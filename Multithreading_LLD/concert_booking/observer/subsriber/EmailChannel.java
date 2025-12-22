package Multithreading_LLD.concert_booking.observer.subsriber;

import Multithreading_LLD.concert_booking.Entities.User;

public class EmailChannel implements IChannel {

    @Override
    public void notify(User user, String message) {
        System.out.println("Email Channel Notification: " + message+" to email :"+user.email);
    }
}
