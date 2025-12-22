package Multithreading_LLD.concert_booking;

import Multithreading_LLD.concert_booking.Entities.LiveShow;
import Multithreading_LLD.concert_booking.Entities.TimeSlot;
import Multithreading_LLD.concert_booking.Entities.User;
import Multithreading_LLD.concert_booking.repository.LiveShowManager;
import Multithreading_LLD.concert_booking.repository.UserManager;
import Multithreading_LLD.concert_booking.strategy.ranking.RankingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class BookingManager {

    // all the sub managers
    LiveShowManager liveShowManager;
    UserManager userManager;

    public BookingManager()
    {
        liveShowManager = new LiveShowManager();
        userManager = new UserManager();

    }


    public void book(User user, String showName , LocalDateTime time , int person ) {

        // check if the slot at that time is there , if there capacity is there

        LiveShow liveShow = liveShowManager.getShowByName(showName);

        int totalCount=liveShow.bookaSlot(user, time , person);


            if ( totalCount !=0 )
                System.out.println("Show "+showName+" "+totalCount+" "+"Slot/s from :" + time.getHour()+ " is booked for user" + user.userid);
            else
                System.out.println("Show not booked for user" + user.userid);

    }

    public boolean cancel(User user, String showName , LocalDateTime time , int person) {

        LiveShow liveShow = liveShowManager.getShowByName(showName);

        for( TimeSlot tt : user.getBookedSlots() )
            if( time.isAfter(tt.startHour) && time.isBefore(tt.endHour))
               if(liveShow.cancelaSlot(user,time , person)){
                  return true;
               }

        return false;
    }

    // search methods
    public void selectAndSearchByStrategy(RankingStrategy rs )
    {
        liveShowManager.searchByStrategy(rs);
    }



    // user login and deregister  // do-re-baba
    public void login(User u)
    {

    }

    // admin methods
    public void addShows(LiveShow liveShow)
    {
        liveShowManager.addShows(liveShow);
    }




}
