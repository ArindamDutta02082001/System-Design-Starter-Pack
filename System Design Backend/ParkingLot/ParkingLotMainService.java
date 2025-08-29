package ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;


import java.util.stream.Collectors;

import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.Ticket;
import ParkingLot.Entities.User;
import ParkingLot.Entities.Vehicle;
import ParkingLot.Service.NotificationService.SubscriberInterface;
import ParkingLot.Service.ParkingFeeService.ParkingFeeStrategy;
import ParkingLot.Service.PaymentService.PaymentService;

public class ParkingLotMainService {



    // here we wll have all the services like parking service , payment service etc

    // all the parkig floors in the parking lot
    List<ParkingFloor> parkingFloors;

    List<Ticket> tickets;

    // setting up the payment service
    PaymentService paymentService;

    // storing list of user
    List<User> listOfUser ;

    // setting the  paymentfee strategy
    ParkingFeeStrategy parkingFeeStrategy = null ;

    // settng the notification service
    List<SubscriberInterface>subscribers;

    // **vv1 although we have set privte contructor but 
    // here we need to expose public setter to inject the other services into this main service

    public void setFloor( ParkingFloor floor )
    {
        parkingFloors.add( floor );
    }

    public void setPaymentService( PaymentService paymentService )
    {
        this.paymentService = paymentService;
    }

    public void pay( Double amount )
    {
        paymentService.payAmount( amount );
    }


    public void setParkingFeeStrategy( ParkingFeeStrategy parkingFeeStrategy )    {
        // set the strategy
        this.parkingFeeStrategy = parkingFeeStrategy;
    }   

    public void subs( SubscriberInterface subscriber)
    {
        // add the user to list of user if not present
        subscribers.add( subscriber );


    }





    // we will make this class singleton

    private static volatile ParkingLotMainService instance = null;

    private ParkingLotMainService() {

        this.parkingFloors = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.listOfUser = new ArrayList<>();
        this.subscribers = new ArrayList<>();

    }

    public static ParkingLotMainService getInstance() {


        if( instance == null )
        synchronized (ParkingLotMainService.class) {

        if (instance == null) {
            instance = new ParkingLotMainService();
        }

        }
        return instance;
    }



    // we will create methods to purchase ticket , park vehicle , unpark vehicle , get available slots etc

    public Ticket purchaseParkingPass( User user , Vehicle vehicle )
    {
        Ticket ticket = new Ticket( UUID.randomUUID().toString() , LocalDateTime.now() ,user , vehicle );
        tickets.add( ticket );



        return ticket;
    }

    // our parking method will take , ticket , user , option in Floors

    public boolean parkVehicle( User user , Ticket ticket, int floorNo )
    {
        ParkingFloor floor = parkingFloors.get( floorNo );

        List<ParkingSpot> listOfAvaliableSpots = floor.parkingSpots.stream().filter(e->e.isAvailable == true
                         && e.spotType.equals(ticket.vehicle.vehicleType)).collect(Collectors.toList());


        if( listOfAvaliableSpots.size() != 0 )
        {
            ParkingSpot p0 = listOfAvaliableSpots.get(0);
            p0.isAvailable = false;
           
            notifyAllSubscribers(" Your vehicle is parked in spot : "+p0.spotId , user);

            return true;
        }

        return false;  // no spot available
    }
   

    // unpark vehicle method
    public Double unparkVehicle( Ticket ticket )
    {

        // set the exit time 
        ticket.setExitTime(LocalDateTime.now());

        // calc the duration and use the fee calc strategy
        long duration = Duration.between(ticket.entryTime,ticket.exitTime).toMillis()/1000*60*60;

        Double bill =  parkingFeeStrategy.calc( ticket.vehicle.vehicleType , duration );

        // current strategy used
        for( int i=0;i<parkingFloors.size();i++)
        {
            
         List<ParkingSpot> bookedSlot = parkingFloors.get(i).parkingSpots.stream().filter(e->e.isAvailable == false
                         && e.spotType.equals(ticket.vehicle.vehicleType)).collect(Collectors.toList());
            if( bookedSlot.size() !=0  )
            {
                bookedSlot.get(0).isAvailable = true;
                        // display the  bill
                        System.out.println("The total bill is : "+bill);

                        // pay the bill
                        paymentService.payAmount(bill);

                        // notify the user
                        notifyAllSubscribers(" The total bill is : "+bill , ticket.user);

                return bill;
            }
        }






        return 0.0;  // some error occured

    }

    // get available slots method
    public void getAvailableSpots( )
    {

        System.out.println("THE AVALIABLE SLOTS ARE : ");
        
        for( int i=0;i<parkingFloors.size();i++)
        {
            System.out.println("Floor : "+(i+1));
            List<ParkingSpot> spots = parkingFloors.get(i).parkingSpots;
            
            for( int j=0;j<spots.size();j++)
            {
 
                System.out.println("SPOT :"+spots.get(j).spotId+" , type : "+spots.get(j).spotType+" free : "+spots.get(j).isAvailable);
            
            }
        }

         System.out.println(" --------------------- ");

    }

    // function to check if the user is existing in the List
    boolean isUserPresent( User u)    {
        return listOfUser.contains(u);
    }


    // notifying function
    public void notifyAllSubscribers( String message , User user)
    {
        for( SubscriberInterface sub : subscribers )
        {
            sub.update( message ,  user);
        }
    }

    
}
