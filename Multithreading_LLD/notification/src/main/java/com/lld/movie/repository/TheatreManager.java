package com.lld.movie.repository;

import com.lld.movie.entities.Theatre;

import java.util.Map;

public class TheatreManager {

    // keeping a city vs threatre map
    Map<String, Theatre> cityTheatreMap;

    // utility methods to add/remove/fetch theatres by city can be added here

    public Theatre getTheatreByCity(String city) {
        return cityTheatreMap.get(city);
    }

    public void addTheatreToCity(String city, Theatre theatre) {
        cityTheatreMap.put(city, theatre);
    }
}
