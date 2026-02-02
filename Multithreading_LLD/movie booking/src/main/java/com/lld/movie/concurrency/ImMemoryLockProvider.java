package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImMemoryLockProvider implements ILockProvider{

    public Integer TTL = 5000; // milliseconds  // can vary from provider to provider

    private  Map<Show, Map<Seat, SeatLock>> seatlocks;  // Stores the locks per show and seat

    // why?? show vs map of seat , seatlock
    // coz user can book the same seat in different shows , so we need to lock the seat for this show
    // not globally for the entire screen




    public ImMemoryLockProvider() {

        // initialize the locks map
        this.seatlocks = new HashMap<>();

    }

//    @Override
//    public void lockSeats(Show show, List<Seat> seat, User user)  {
//
//        // check if the show exist , if the seat is already locked by someone , if exired or not
//
//        if(!seatlocks.containsKey(show))
//            seatlocks.put(show,new java.util.HashMap<>());
//
//        // get the seats of the show
//        Map<Seat, SeatLock> seatLockMap = seatlocks.get(show);
//
//        synchronized (seatLockMap)  // synchronize on the seatLockMap for this show
//        {
//            for (Seat s : seat)  // iterate over the seats user wants to lock
//            {
//                if (seatLockMap.containsKey(s)) {
//                    SeatLock currSeatLock = seatLockMap.get(s);
//                    // check if lock is expired
//                    if (currSeatLock.getLockExpiryTime().isAfter(LocalDateTime.now())) {
//                        System.out.println("Seat " + s.getSeatNumber() + " is already locked for show " + show.getShowId());
//                        return ;    // not allowing partial booking
//                    } else {
//                        // user should be allowed for partial booking
//                        SeatLock newSeatLock = new SeatLock(show, s, user, java.time.LocalDateTime.now());
//                        seatLockMap.put(s, newSeatLock);
//                    }
//
//                }
//            }
//        }
//
//    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, User user) {

        seatlocks.putIfAbsent(show, new HashMap<>());

        Map<Seat, SeatLock> seatLockMap = seatlocks.get(show);

        synchronized (seatLockMap) {

            // STEP 1: validate ALL seats first
            for (Seat s : seats) {

                SeatLock existing = seatLockMap.get(s);

                if (existing != null &&
                        existing.getLockExpiryTime().isAfter(LocalDateTime.now())) {

                    throw new RuntimeException(
                            "Seat " + s.getSeatNumber() + " already locked for show " + show.getShowId()
                    );
                }
            }

            // STEP 2: lock them all
            for (Seat s : seats) {
                seatLockMap.put(s,
                        new SeatLock(
                                show,
                                s,
                                user,
                                LocalDateTime.now().plusSeconds(30)   // TTL
                        )
                );
            }
        }
    }


    @Override
    public void unlockSeats(Show show, List<Seat> seat, User user) {

        if(!seatlocks.containsKey(show))
            return;

        Map<Seat, SeatLock> seatLockMap = seatlocks.get(show);

        synchronized (seatLockMap)  // synchronize on the seatLockMap for this show
        {
            for (Seat s : seat)  // iterate over the seats user wants to unlock
            {
                if (seatLockMap.containsKey(s)) {
                    SeatLock currSeatLock = seatLockMap.get(s);
                    // only the user who locked the seat can unlock it
                    if (currSeatLock.getLockedBy().equals(user)) {
                        seatLockMap.remove(s);
                    }
                }
            }
        }

    }

//    @Override
//    public boolean validateLock(Show show, Seat seat, User user) {
//        if(!seatlocks.containsKey(show))
//            return false;
//
//    }


    @Override
    public List<Seat> getLockedSeats(Show show) {

        if(!seatlocks.containsKey(show))
            return null;

        Map<Seat, SeatLock> seatLockMap = seatlocks.get(show);

        return List.copyOf(seatLockMap.keySet());
    }

    @Override
    public boolean isSeatLockeForThisShow(Show show , Seat seat)
    {
        if(!seatlocks.containsKey(show))
            return false;

        Map<Seat, SeatLock> seatLockMap = seatlocks.get(show);

        return seatLockMap.containsKey(seat);
    }


}
