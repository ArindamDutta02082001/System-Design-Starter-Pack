
package src;

import src.Entities.OfferRide;
import src.Entities.User;
import src.Entities.enums.VehicleStatus;
import src.strategy.RideSelectionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideManager {


    private static RideManager instance = null;
    public Map< Integer , User> users;
    public Map<Integer , List<OfferRide>> offerRides;


    public RideSelectionStrategy rideSelectionStrategy;

    // add users


    // singleton

    private RideManager()
    {
        users = new HashMap<>();
        offerRides = new HashMap<>();
    }

    //
    public static RideManager getInstance()
    {
        if( instance == null )
        {
            synchronized (RideManager.class)
            {
                if(instance == null)
                    instance = new RideManager();
            }
        }
        return instance;
    }


    // add users
    public void addUsers( User u )
    {
        this.users.put(u.id , u);
    }

    public void removeUsers( User u )
    {
        this.users.remove(u.id);
    }


    // add offer ride
    public void offerRides(User u , OfferRide offerRide)
    {
//        u.addRides(offerRide);
        if( offerRides.containsKey(u.id))
        {
            List<OfferRide> rides = offerRides.get(u.id);
            rides.add(offerRide);
            offerRides.put(u.id , rides);

        }
        else
        {
            List<OfferRide> rides = new ArrayList<>();
            rides.add(offerRide);
            offerRides.put(u.id , rides);
        }
        u.offered++;
    }

    // selection src.strategy and select

    public void selectRide( User u , String src , String dest , int seats , RideSelectionStrategy r)
    {
        this.rideSelectionStrategy =r;

        OfferRide getRide = r.rideSelect(this, src , dest);

        // taken and
        u.taken++;
        getRide.vehicle.vehicleStatus = VehicleStatus.ONGOING;

        System.out.println( u.name +" src :"+src+" dest :"+dest+" seat :"+seats+" vehicle :"+getRide.vehicle.vname);
    }

    //
    public  void printRideStat()
    {
        for( Integer n : users.keySet())
        {
            System.out.println("User :"+users.get(n).name+" taken+"+users.get(n).taken+" Given"+users.get(n).offered);
        }

    }


    // end ride








}
