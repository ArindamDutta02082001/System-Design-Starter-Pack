package com.lld.movie.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
public class Screen {

    Integer screenId;
    String name;

    public Screen(Integer screenId, String name) {
        this.screenId = screenId;
        this.name = name;
    }

    // will have show slot , seats ( can be reused )

    Map<Integer , Show> shows = new HashMap<>();

    Map<Integer,Seat> seatMap = new HashMap<>();


    // function to add show
    public void addShow(Show show){
        shows.put(show.getShowId() , show);
    }

    // function to add seat
    public void addSeat(Seat seat){
        seatMap.put(seat.getSeatId() , seat);
    }

    // utility function to get all the shows
    public List<Show> getAllShows(){
        return List.copyOf(shows.values());
    }




}
