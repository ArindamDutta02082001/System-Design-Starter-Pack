package com.lld.movie.repository;

import com.lld.movie.concurrency.ILockProvider;
import com.lld.movie.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreManager {

    // keeping a city vs threatre map
    Map<Integer, Theatre> cityTheatreMap = new HashMap<>();


    // utility methods to add/remove/fetch theatres by city can be added here

    public Theatre getTheatreByCity(String city) {
        return cityTheatreMap.get(city);
    }

    public void addTheatreToCity(int theatreId, Theatre theatre) {
        cityTheatreMap.put(theatreId, theatre);
    }


    // get movies in each theatre
    public List<Show> getMoviesInTheatre(int theatreId) {
        Theatre theatre = cityTheatreMap.get(theatreId);

        List<Screen> allScreens = theatre.getAllScreens(); // placeholder
        return allScreens.stream()
                .flatMap(screen -> screen.getAllShows().stream())
                .toList();
    }

    // to get all seats of a theatre id and screen id and show id
    public List<Seat> getAllShowsOfTheatreScreen(int theatreId, int screenId ) {

        Theatre theatre = cityTheatreMap.get(theatreId);
        Screen screen = theatre.getScreenMap().get(screenId);

        return List.copyOf(screen.getSeatMap().values()); // placeholder

    }




}
