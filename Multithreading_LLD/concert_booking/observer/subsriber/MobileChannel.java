package Multithreading_LLD.concert_booking.observer.subsriber;

import Multithreading_LLD.concert_booking.Entities.User;

public class MobileChannel implements IChannel {

    @Override
    public void notify(User user, String message) {
        System.out.println("Mobile Channel Notification: " + message+" in mobile"+user.mobile);
    }
}
