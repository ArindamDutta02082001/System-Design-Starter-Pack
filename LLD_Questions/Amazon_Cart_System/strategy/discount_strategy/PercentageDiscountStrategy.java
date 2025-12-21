package strategy.discount_strategy;

public class PercentageDiscountStrategy implements DiscountStrategy{


    // 10% discount on the total
    @Override
    public double applyDiscount(double amount) {

        return amount * 0.1;
    }
}
