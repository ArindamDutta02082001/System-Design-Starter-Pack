package Multithreading_LLD.concert_booking.repository;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class LiveShowRepository {

    List<LiveShow> liveShows = new ArrayList<>();  // hold the shows

    public void addShows( LiveShow show )
    {
        liveShows.add(show);
    }

    public List<LiveShow> getLiveShows()
    {
        return liveShows;
    }


}
