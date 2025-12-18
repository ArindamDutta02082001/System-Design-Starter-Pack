package Multithreading_LLD.concert_booking.strategy.ranking;

import Multithreading_LLD.concert_booking.Entities.LiveShow;

import java.util.List;

public interface RankingStrategy {
    public List<LiveShow> rank(List<LiveShow> liveShows);
}
