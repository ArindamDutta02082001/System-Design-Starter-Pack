package Multithreading_LLD.concert_booking.repository;

import Multithreading_LLD.concert_booking.Entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    Map<String, User> userMap = new HashMap<>();

    // utility functions

    public void registerUser( User user)
    {
        if(userMap.containsKey(user.userid))
            System.out.println("User is already registered");
        userMap.put(user.userid,user);
    }

    public void unregister( User u )
    {
        if( !userMap.containsKey(u.userid) )
            System.out.println("User is not there");
        userMap.remove(u);
    }

    // other methods we can add for now this only


}
