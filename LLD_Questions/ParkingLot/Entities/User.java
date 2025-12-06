package ParkingLot.Entities;

import ParkingLot.factory.Vehicle;
import ParkingLot.strategy.payments.Payment;

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

public class User {
    
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

    public User( int id, String name , String mobile , String email)
    {
        this.id = id;   
        this.name = name;
        this.mobile = mobile;
        this.email = email;
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
}


