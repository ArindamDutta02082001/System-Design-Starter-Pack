package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;

import java.util.List;

public class RedisLockProvider implements ILockProvider{
    @Override
    public void lockSeats(Show show, List<Seat> seat, User user) throws Exception {

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

    // not used here but in real world we can use Redisson or Jedis client to implement distributed lock
}
