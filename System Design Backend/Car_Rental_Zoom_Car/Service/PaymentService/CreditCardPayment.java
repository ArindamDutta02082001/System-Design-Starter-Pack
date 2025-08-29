package Car_Rental_Zoom_Car.Service.PaymentService;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay( Double amount)
    {
        System.out.println("amount paid via CC : "+amount);
    }
    
}
