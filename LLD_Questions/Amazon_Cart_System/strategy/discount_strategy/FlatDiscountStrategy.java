package strategy.discount_strategy;

public class FlatDiscountStrategy implements DiscountStrategy{


    // returning the discounted price only

    // flat discount if yur item product is >200 then only
    @Override
    public double applyDiscount(double amount) {


        // applying flat 100 rs off
        if( amount < 200.0 )
            return 0.0;

        return 100.0;
    }
}
