package ParkingLot.strategy.payments;


public class DebitCardPaymentStrategy implements Payment {

    @Override
    public void pay( Double amount)
    {
        System.out.println("amount paid via DC : "+amount);
    }
    
}
