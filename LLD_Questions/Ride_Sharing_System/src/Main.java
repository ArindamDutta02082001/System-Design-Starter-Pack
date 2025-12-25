package src;

import src.Entities.OfferRide;
import src.Entities.User;
import src.Entities.Vehicle;
import src.strategy.MostVacantStrategy;
import src.strategy.RideSelectionStrategy;

public class Main {

    public static void main( String args[] )
    {
        RideManager r = RideManager.getInstance();

        // create users
        User u1 = new User(1 , "Rohan");
        User u2 = new User(2, "Shashank");
        // create vehicle
        Vehicle v1 = new Vehicle("Swift" , "KA123");
        Vehicle v2 = new Vehicle("Activa" , "KA456");
        Vehicle v3 = new Vehicle("Dezire" , "KA789");
        Vehicle v4 = new Vehicle("Baleno" , "KA4346");

        u1.addVehicle(v1);
        u1.addVehicle(v2);

        OfferRide offerRide1 = new OfferRide(u1, "BLR" ,"GOA" , 5 , v1 );
        OfferRide offerRide2 = new OfferRide(u1, "HYD" ,"GOA" , 5 , v2 );

        OfferRide offerRide3 = new OfferRide(u2, "SIKKIM" ,"MYSORE" , 5 , v1 );
        OfferRide offerRide4 = new OfferRide(u2, "BENGAL" ,"DELHI" , 5 , v2 );


        r.addUsers(u1);
        r.addUsers(u2);

        r.offerRides(u1,offerRide1);
        r.offerRides(u1,offerRide2);
        r.offerRides(u2,offerRide3);
        r.offerRides(u2,offerRide4);

        // creating offer rides


//       actions

        RideSelectionStrategy rs = new MostVacantStrategy();
        r.selectRide( u1 , "SIKKIM" , "MYSORE" , 1,rs);
        r.selectRide( u1 , "SIKKIM" , "MYSORE" , 1,rs);

        r.printRideStat();



    }

}
