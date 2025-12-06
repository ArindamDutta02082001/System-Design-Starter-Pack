package ParkingLot.strategy.payments;


public class UPIPaymentStrategy implements Payment {

    @Override
    public void pay( Double amount)    {
        System.out.println("amount paid via UPI : "+amount);
    }
    
}
