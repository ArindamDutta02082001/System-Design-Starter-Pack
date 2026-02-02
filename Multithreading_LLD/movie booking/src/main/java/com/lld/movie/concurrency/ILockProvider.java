package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;

import java.util.List;

public interface ILockProvider {

    // user will send list of seats of 1 Show and those seats will be locked ( if avaliable ) for 5 sec for that show
    void lockSeats(Show show, List<Seat> seat, User user) ;
    void unlockSeats(Show show, List<Seat> seat, User user);

//    boolean validateLock(Show show, Seat seat, User user);

    boolean isSeatLockeForThisShow(Show show , Seat seat);
    List<Seat> getLockedSeats(Show show);
}
