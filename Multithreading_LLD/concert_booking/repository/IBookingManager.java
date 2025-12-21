package Multithreading_LLD.concert_booking.repository;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.time.LocalDateTime;

public interface IBookingManager {

    public void book(User user , LiveShow liveShow , LocalDateTime time);
    public void cancel( User user , LiveShow l );

}
