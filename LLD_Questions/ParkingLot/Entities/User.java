package ParkingLot.Entities;

import ParkingLot.factory.Vehicle;
import ParkingLot.observer.subscriber.ChannelInterface;
import ParkingLot.observer.subscriber.Subscriber;
import ParkingLot.strategy.payments.Payment;

import java.util.ArrayList;
import java.util.List;

/**

Why not “User has Ticket”?

Because:

A User exists independently of tickets

Tickets are created because of the user’s action

Tickets are temporary entities

A user may come to the parking lot tomorrow with another vehicle → new ticket

If a user is deleted from system, all their tickets become meaningless

So placing Ticket inside User makes the model heavy and wrong.
 
*/

public class User implements Subscriber {
    
    public int id;
    public String name;

    // mobile and email for notification purpose
    public String mobile;
    public String email;

    // at a time only one user can have one vehicle in parking lot
    public Vehicle vehicle;


    // payment service embeddin here as user can have his own payment method    
    //  **vvi dekho jaha jaha use karna hai waha waha aise strategy embedding karna hai
    public Payment paymentStrategy;

    // **vvi observer pattern : to store the list of user preferred channels
    List<ChannelInterface> preferredChannels;


    public User( int id, String name , String mobile , String email)
    {
        this.id = id;   
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.preferredChannels = new ArrayList<>();
    }

    // add a vehicle to user
    public void addVehicle( Vehicle vehicle )
    {
        this.vehicle = vehicle;
    }






    // during exit we can embed the payment strategy here
    public void setPaymentStrategy( Payment paymentStrategy )
    {
        this.paymentStrategy = paymentStrategy;
    }

    // method to pay the parking fee
    public void payParkingFee( Double amount )
    {
        paymentStrategy.pay( amount );
    }



    // observer pattern to notify the user via preferred channels

    public void addPreferredChannel( ChannelInterface channel )
    {
        this.preferredChannels.add( channel );
    }

    @Override
    public void update(String message) {
        for( ChannelInterface ch : preferredChannels )
        {
            ch.notify( message , this );
        }
    }
}


