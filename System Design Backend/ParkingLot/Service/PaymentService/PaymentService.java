package ParkingLot.Service.PaymentService;


public class PaymentService {

    PaymentStrategy paymentStrategy;

    public PaymentService( PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    } 

    // method to execute payment
    public void payAmount( Double amount)
    {
        paymentStrategy.pay(amount);
    }

    
    
}
