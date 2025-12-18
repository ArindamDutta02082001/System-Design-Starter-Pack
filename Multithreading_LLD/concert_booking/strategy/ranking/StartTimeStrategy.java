package Multithreading_LLD.concert_booking.strategy.ranking;

import Multithreading_LLD.concert_booking.Entities.LiveShow;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StartTimeStrategy implements RankingStrategy{
    @Override
    public List<LiveShow> rank(List<LiveShow> liveShows) {
                liveShows.sort(Comparator.comparing((LiveShow a) -> a.getSlots().getFirst().timeSlot.startHour));
        return liveShows;
    }
}
