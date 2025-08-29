package ParkingLot.Service.PaymentService;


public class DebitCardPayment implements PaymentStrategy {

    @Override
    public void pay( Double amount)
    {
        System.out.println("amount paid via DC : "+amount);
    }
    
}
