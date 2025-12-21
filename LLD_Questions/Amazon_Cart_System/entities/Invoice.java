package entities;

import java.util.UUID;


// just to return the invoice after order is placed

public class Invoice {

    // It will be summation of the users and the orders and the final receipts

    Customer customer;
    ShoppingCart shoppingCart;
    Double finalPrice;

    Integer orderId = UUID.randomUUID().hashCode();

    public Invoice(Customer customer , ShoppingCart shoppingCart) {

        this.customer = customer;
        this.shoppingCart = shoppingCart;
        this.finalPrice = shoppingCart.getTotal();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", shoppingCart=" + shoppingCart +
                ", finalPrice=" + finalPrice +
                ", orderId=" + orderId +
                '}';
    }
}
