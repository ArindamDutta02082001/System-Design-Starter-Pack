package ParkingLot.Service.PaymentService;


public class UPIPayment implements PaymentStrategy {

    @Override
    public void pay( Double amount)    {
        System.out.println("amount paid via UPI : "+amount);
    }
    
}
