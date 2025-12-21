package state;

import entities.Customer;
import entities.Invoice;
import entities.ShoppingCart;
import repository.OrderStateManager;

public class DeliverOrderState implements OrderState {

    OrderStateManager orderStateManager;

    public DeliverOrderState(OrderStateManager o) {
        this.orderStateManager = o;
    }


    @Override
    public Invoice placeOrder(OrderStateManager orderStateManager, Customer c, ShoppingCart s) {
        System.out.println("Order is in delivery state!!");
        return null;
    }

    @Override
    public void shipOrder(OrderStateManager orderStateManager) {
        System.out.println("Order is in delivery state!!");
    }

    @Override
    public void cancelOrder(OrderStateManager orderStateManager) {
        System.out.println("Order is delivered , can't cancel now !!");
    }

    @Override
    public void deliverOrder(OrderStateManager orderStateManager) {
        System.out.println("Order is out for delivery !!");
        orderStateManager.setCurrentState( null );
    }
}
