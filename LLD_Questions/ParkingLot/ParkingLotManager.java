package ParkingLot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ParkingLot.Entities.Floor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.Ticket;
import ParkingLot.Entities.User;


import ParkingLot.factory.Vehicle;
import ParkingLot.strategy.parkingfee.ParkingFee;
import ParkingLot.strategy.spotfinder.SpotFinder;
import ParkingLot.observer.publisher.Publisher;
import ParkingLot.observer.subscriber.SubscriberInterface;

public class ParkingLotManager {



    // here we wll have all the services like parking service , payment service etc


    // set by the parking lot admin

    // all the parking floors in the parking lot    --> multi floor parking lot
    Map<Integer , Floor> floors;   // floor no : floor object   

    Map<Integer,Ticket> tickets;  // user id : ticket object
    
    // setting the  paymentfee & spot finder strategy
    ParkingFee parkingFeeStrategy = null ;
    SpotFinder spotFinderStrategy = null ;


    // setting up for th user

    // PaymentService paymentService;    --> not here it has to be in the user service , per user it will be different right **vvi 

    // storing list of user
    Map<Integer , User> listOfUser ;


    // settign the observer pattern for notification
    Publisher publisher;

 
    // ignore these getter and setters for now as we kept all public for simplicity

    public void setFloor( int floorNo , Floor floor )
    {
        floors.put( floorNo ,floor );
    }

    public void setUsers( Integer id , User user )
    {
        listOfUser.put( id , user );
    }

    public void setParkingFeeStrategy( ParkingFee parkingFeeStrategy )    {
        // set the strategy
        this.parkingFeeStrategy = parkingFeeStrategy;
    }   

    public void setSpotFinderStrategy( SpotFinder spotFinderStrategy )    {
        // set the strategy
        this.spotFinderStrategy = spotFinderStrategy;
    }

   



    // we will make this class singleton

    private static volatile ParkingLotManager instance = null;

    private ParkingLotManager() {
        this.floors = new HashMap<>();
        this.tickets = new HashMap<>();
        this.listOfUser = new HashMap<>();
        this.publisher = new Publisher();
    }

    public static ParkingLotManager getInstance() {


        if( instance == null )
        synchronized (ParkingLotManager.class) {

        if (instance == null) {
            instance = new ParkingLotManager();
        }

        }
        return instance;
    }







     // utility functions


    // for the user notification subscription
    public void subscribe( SubscriberInterface subscriber)
    {
        // add the user to list of user if not present
        publisher.subscribe( subscriber );
    }

    // creating ticket for parking
    public Ticket purchaseParkingPass( User user , Vehicle vehicle )
    {
        return new Ticket( UUID.randomUUID().toString() , LocalDateTime.now() ,user , vehicle );
     
    }


    // 2 main trigger functions


    // our parking method will take , ticket , user , option in Floors

    public void parkVehicle( User user , Ticket ticket )
    {

        // if you want to do it here 
        // you can do but I have created another method
        // Ticket ticket = new Ticket( UUID.randomUUID().toString() , LocalDateTime.now() ,user , vehicle );
        
        tickets.put( user.id , ticket );


        // fiding suitable spot using strategy
        ParkingSpot spot = spotFinderStrategy.findSpot( floors , ticket.vehicle.vehicleType );
        // spot.isAvailable = false;
        // spot.currentVehicle = user.vehicle;  -> wring
        spot.assignVehicle(user.vehicle); // correct

        // observer pattern notification
        publisher.notifySubscribers(user, "Tring tring !! you vehicle is parked at : " + spot.spotId);

    }
   

    // unpark vehicle method
    public Double unparkVehicle( Ticket ticket )
    {

        // set the exit time 
        ticket.setExitTime(LocalDateTime.now());

//        long duration = ticket.getParkingDurationInHours();
         long duration = 1; // for testing purpose

        // caculate parking fee using strategy
        Double amount = parkingFeeStrategy.calc(  ticket.vehicle.vehicleType , duration  );

        // notify user about unparking
        publisher.notifySubscribers(ticket.user, "Tring tring !! your vehicle is unparked. Please pay : " + amount);

        return amount;

    }


    
}
