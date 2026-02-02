package com.lld.movie.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Show {

    Integer showId ;

    // for concert booking we created a TimeSlot class
    LocalDateTime startTime;
    //    LocalDateTime endTime;

    int durationInMinutes;      // this is redundant as each movie will hvae its duration stored inside

    Movie movie;

    // to add movie
    public Show(int showid ,LocalDateTime startTime , int durationInMinutes, Movie movie) {
        this.showId = showid;
        this.startTime = startTime;
        this.durationInMinutes = durationInMinutes;
        this.movie = movie;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Seat)) return false;
//        Show show = (Show) o;
//        return showId == show.showId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(showId);
//    }




}
