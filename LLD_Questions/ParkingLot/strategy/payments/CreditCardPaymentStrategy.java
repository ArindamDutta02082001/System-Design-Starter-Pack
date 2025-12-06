package ParkingLot.strategy.payments;

public class CreditCardPaymentStrategy implements Payment {

    @Override
    public void pay( Double amount)
    {
        System.out.println("amount paid via CC : "+amount);
    }
    
}
