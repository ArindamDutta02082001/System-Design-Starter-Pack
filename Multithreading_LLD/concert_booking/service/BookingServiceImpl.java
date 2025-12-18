package Multithreading_LLD.concert_booking.service;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.ShowSlot;
import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.Entities.enums.Genre;
import Multithreading_LLD.concert_booking.repository.LiveShowRepository;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingENUM;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class BookingServiceImpl implements BookingService{

    @Override
    public void book(User user, LiveShow liveShow , LocalDateTime time) {

        // check if the slot at that time is there , if there capacity is there
        if( liveShow.bookSlot(time,user))
            System.out.println("Slot from :"+time.getHour()+" is booked for the user"+user.userid);
    }

    @Override
    public void cancel(User user, LiveShow l) {

    }

    @Override
    public void searchByGenre(RankingStrategy rankingStrategy, LiveShowRepository liveShowRepository) {
        List<LiveShow> searchAns = rankingStrategy.rank(liveShowRepository.getLiveShows());
        for( LiveShow l : searchAns)
                for(ShowSlot s : l.getSlots())
                        System.out.println( "Show :"+l.name+" start :"+s.timeSlot.startHour+" genre :"+l.genre);

    }


}
