package state;

import entities.Customer;
import entities.Invoice;
import entities.Order;
import entities.ShoppingCart;
import entities.enums.ORDER_STATUS;

public class DeliverOrderState implements OrderState {

    Order order;

    public DeliverOrderState(Order o) {
        this.order = o;
    }


    @Override
    public Invoice placeOrder(Customer c, ShoppingCart s) {
        System.out.println("Order is in delivery state!!");
        return null;
    }

    @Override
    public void shipOrder() {
        System.out.println("Order is in delivery state!!");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Order is delivered , can't cancel now !!");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Order is out for delivery !!");
        order.status = ORDER_STATUS.DELIVERED;
        order.setCurrentState( null );
    }
}
