package Multithreading_LLD.concert_booking.repository;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.ShowSlot;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveShowManager {

    public LiveShowManager( )
    {
    }

    Map<String,LiveShow> liveShows = new HashMap<>();  // hold the shows

    public void addShows( LiveShow show )
    {
        liveShows.put(show.name , show);
    }

    public List<LiveShow> getallLiveShows()
    {
        return liveShows.values().stream().toList();
    }

    public LiveShow getShowByName( String name )
    {
        return liveShows.get(name);
    }

    // searching by ranking strategy

    public void searchByStrategy(RankingStrategy rankingStrategy) {
        List<LiveShow> searchAns = rankingStrategy.rank(getallLiveShows());
        for( LiveShow l : searchAns)
        {
            for(ShowSlot s : l.getSlots())
                System.out.println( " For Show : "+l.name+" Slots : start is : "+s.timeSlot.startHour.getHour()+" & genre :"+l.genre);
        }
    }


}
