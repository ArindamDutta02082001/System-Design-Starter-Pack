package com.lld.movie.repository;


import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;

import java.util.*;

// will be used to
public class SeatManager {

    // storing the show vs seats booke for that show
    Map<Show, Set<Seat>> seatBooked;

    public SeatManager ()
    {
        this.seatBooked = new HashMap<>();
    }

    // to book seat for a show
    public void bookSeats( Show show , Seat seatsToBook )
    {
        if(!seatBooked.containsKey(show))
            seatBooked.put(show , new HashSet<>());


        Set<Seat> alreadyBookedSeats = seatBooked.get(show);
            alreadyBookedSeats.add(seatsToBook);
            seatBooked.put(show , alreadyBookedSeats);

    }

    // get all booked seat of a show
    public Set<Seat> getAllBookedSeats(Show show )
    {
        return seatBooked.get(show);
    }

}
