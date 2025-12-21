package Multithreading_LLD.concert_booking.strategy.payment;

public class DebitCard implements PaymentStrategy {
    @Override
    public void  pay(Double amt) {
        System.out.println(" Payment using Debit card !! " + amt);
    }
}
