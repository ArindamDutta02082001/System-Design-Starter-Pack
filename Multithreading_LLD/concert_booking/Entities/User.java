package Multithreading_LLD.concert_booking.Entities;

import Multithreading_LLD.concert_booking.observer.subsriber.IChannel;
import Multithreading_LLD.concert_booking.observer.subsriber.Subscriber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber {

    public List<IChannel> preferredChannels;

    public String userid;

    // for observer patttern
    public String mobile ;
    public String email;

    List<TimeSlot> bookedSlots;

    public User(String id , String mob , String email)
    {
        this.userid=id;
        this.email =email;
        this.mobile = mob;
        this.preferredChannels = new ArrayList<>();
        this.bookedSlots = new ArrayList<>();
    }

    // will be used to put the booked slot for users
    public void bookUserSlot( TimeSlot tt )
    {
        bookedSlots.add(tt);
    }

    public void removeUserSlot( TimeSlot tt )
    {
        bookedSlots.remove(tt);
    }

    public List<TimeSlot> getBookedSlots()
    {
        return this.bookedSlots;
    }


    @Override
    public void update(String messages) {
        for( IChannel channel : preferredChannels )
        {
            channel.notify(this,messages);
        }
    }
}
