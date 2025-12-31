package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;

import java.util.List;
import java.util.Map;

public class ImMemoryLockProvider implements ILockProvider{

    // Stores the locks per show and seat
    private  Map<Show, Map<Seat, SeatLock>> seatlocks;

    public Integer TTL = 5000; // milliseconds  // can vary from provider to provider

    // why?? show vs map of seat , seatlock
    // coz user can book the same seat in different shows , so we need to lock the seat for this show
    // not globally for the entire screen

    public ImMemoryLockProvider() {
        // initialize the locks map
        this.seatlocks = new java.util.HashMap<>();

    }

    @Override
    public void lockSeats(Show show, List<Seat> seat, User user) throws Exception {

        // check if the show exist , if the seat is already locked by someone , if exired or not

        if(!seatlocks.containsKey(show))
            seatlocks.put(show,new java.util.HashMap<>());

            // get the seats of the show
        Map<Seat, SeatLock> seatLockMap = seatlocks.get(show);

            for(Seat s : seat)  // iterate over the seats user wants to lock
            {
                if(seatLockMap.containsKey(s))
                {
                    SeatLock currSeatLock = seatLockMap.get(s);
                    // check if lock is expired
                    if(currSeatLock.getLockExpiryTime().isAfter(java.time.LocalDateTime.now()))
                    {
                       System.out.println("Seat "+ s.getSeatNumber() + " is already locked for show " + show.getShowId());
                    }
                    else
                    {
                        // user should be allowed for partial booking
                        SeatLock newSeatLock = new SeatLock(show,s,user,java.time.LocalDateTime.now());
                        seatLockMap.put(s,newSeatLock);
                    }

                }
            }


    }

    @Override
    public void unlockSeats(Show show, List<Seat> seat, User user) {

    }

//    @Override
//    public boolean validateLock(Show show, Seat seat, User user) {
//        return false;
//    }
//
//    @Override
//    public List<Seat> getLockedSeats(Show show) {
//        return null;
//    }
}
