package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;

import java.util.List;

public interface ILockProvider {

    void lockSeats(Show show, List<Seat> seat, User user) throws Exception;
    void unlockSeats(Show show, List<Seat> seat, User user);
//    boolean validateLock(Show show, Seat seat, User user);
//    List<Seat> getLockedSeats(Show show);
}
