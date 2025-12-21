package strategy.discount_strategy;

import entities.ShoppingCart;

import java.util.List;

public class DiscountEngine {

    private final List<DiscountStrategy> discounts = List.of(
            new FlatDiscountStrategy(),
            new PercentageDiscountStrategy()
    );

    public Double applyBestCoupon(ShoppingCart cart) {

        DiscountStrategy bestdis = null;
        double maxDiscount = 0;

        for (DiscountStrategy dis : discounts) {

//            if (coupon.isApplicable(cart)) {
//  for loyalty coupon we can keep a User flag
            // for first time also same flag we can keep

                double discount = dis.applyDiscount(cart.getTotal());

                if (discount > maxDiscount) {
                    maxDiscount = discount;
                    bestdis = dis;
                }
//            }
        }

        return maxDiscount;
    }

}
