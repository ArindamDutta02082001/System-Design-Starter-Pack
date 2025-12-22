package Multithreading_LLD.concert_booking.strategy.payment;

public class CreditCard implements PaymentStrategyNOTUSED {
    @Override
    public void  pay(Double amt) {
        System.out.println(" Payment using Credit card !! " + amt);
    }
}
