package com.lld.movie.strategy.payment;

public class CreditCard implements PaymentStrategy {
    @Override
    public void  pay(Double amt) {
        System.out.println(" Payment using Credit card !! " + amt);
    }
}
