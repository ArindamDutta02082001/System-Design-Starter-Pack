package strategy.payment_strategy;

public class DebitCard implements PaymentStrategy {
    @Override
    public void  pay(Double amt) {
        System.out.println(" Payment using Debit card !! " + amt);
    }
}
