package com.lld.movie.repository;

import com.lld.movie.entities.Show;

import java.util.HashMap;
import java.util.Map;

public class ShowManager {

    Map<Integer, Show> showMap ;

    public ShowManager()
    {
        showMap = new HashMap<>();
    }


    public void addShow( Show show )
    {
        showMap.put(show.getShowId() , show);
    }

    // get show by showId
    public Show getShowById( int showId )
    {
        return showMap.get(showId);
    }
}
