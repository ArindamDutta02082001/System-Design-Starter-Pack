package Multithreading_LLD.concert_booking.service;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.Entities.enums.Genre;
import Multithreading_LLD.concert_booking.repository.LiveShowRepository;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingENUM;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.time.LocalDateTime;

public interface BookingService {

    public void book(User user , LiveShow liveShow , LocalDateTime time);
    public void cancel( User user , LiveShow l );

    public void searchByGenre(RankingStrategy rankingStrategy , LiveShowRepository liveShowRepository);


}
