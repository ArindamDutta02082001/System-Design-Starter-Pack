package com.lld.movie.concurrency;

import com.lld.movie.entities.Seat;
import com.lld.movie.entities.Show;
import com.lld.movie.entities.User;

import java.util.List;
import java.util.Map;

public class RedisLockProvider implements ILockProvider{

    //NOT USING THIS CURRENTLY

    @Override
    public void lockSeats(Show show, List<Seat> seat, User user) {

    }

    @Override
    public void unlockSeats(Show show, List<Seat> seat, User user) {

    }

//    @Override
//    public boolean validateLock(Show show, Seat seat, User user) {
//        return false;
//    }


    @Override
    public List<Seat> getLockedSeats(Show show) {
        return null;
    }

    @Override
    public boolean isSeatLockeForThisShow(Show show , Seat seat)
    {

            return false;

    }

    // not used here but in real world we can use Redisson or Jedis client to implement distributed lock
}
