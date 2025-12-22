package Multithreading_LLD.concert_booking.strategy.ranking;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.enums.Genre;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GenreStrategy implements RankingStrategy{

    Genre genre;
    public GenreStrategy(Genre g)  // we will return the shows of this genre only
    {
        this.genre = g;
    }

    @Override
    public List<LiveShow> rank(List<LiveShow> liveShows) {

        return liveShows.stream().filter(e->e.genre.equals(genre)).collect(Collectors.toList());
    }
}
