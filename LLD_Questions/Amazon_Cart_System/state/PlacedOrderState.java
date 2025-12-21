package state;

import entities.Customer;
import entities.Invoice;
import entities.ShoppingCart;
import repository.OrderStateManager;

public class PlacedOrderState implements OrderState{

    OrderStateManager orderState;

    public PlacedOrderState(OrderStateManager o)    {
        this.orderState = o;
    }
    @Override
    public Invoice placeOrder(OrderStateManager orderStateManager, Customer c , ShoppingCart shoppingCart) {
        System.out.println("Order has been placed successfully!");
        orderState.setCurrentState( orderStateManager.shippedState );

        return new Invoice( c , shoppingCart );
    }

    @Override
    public void shipOrder(OrderStateManager orderStateManager) {
        System.out.println("Order will be shipped !!");
    }

    @Override
    public void cancelOrder(OrderStateManager orderStateManager) {
        orderState.setCurrentState( null );
        System.out.println("Order is cancelled !!");

    }

    @Override
    public void deliverOrder(OrderStateManager orderStateManager) {
        System.out.println("Order is yet to be shipped !!");
    }
}