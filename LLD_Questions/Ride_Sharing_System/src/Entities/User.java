package src.Entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    public Integer id;
    public String name;

//    List<OfferRide> offerRides;

    List<Vehicle> vehicles;

//    Role role;

    public Integer offered;

    public Integer taken;

    public User( Integer id, String name )
    {
        this.id =id;
        this.name = name;
        this.vehicles = new ArrayList<>();
//        this.offerRides = new ArrayList<>();
        offered = 0;
        taken=0;
//        role = Role.USER;


    }

    // add remove vehicle
    public boolean addVehicle( Vehicle v )
    {
        if( this.vehicles.contains(v))
            return false;

         this.vehicles.add(v);
         return true;
    }

    public boolean removeVehicle( Vehicle v )
    {
        if(!this.vehicles.contains(v))
            return false;

        this.vehicles.remove(v);
        return true;
    }

    // register offer rides
//    public boolean addRides( OfferRide offerRide  )
//    {
//        if( this.offerRides.contains(offerRide))
//            return false;
//
//        this.offerRides.add(offerRide);
//        return true;
//    }

    // remove at end

}
