package state;

import entities.Customer;
import entities.Invoice;
import entities.Order;
import entities.ShoppingCart;
import entities.enums.ORDER_STATUS;

public class PlacedOrderState implements OrderState{

    Order order;

    public PlacedOrderState(Order o)    {
        this.order = o;
    }
    @Override
    public Invoice placeOrder(Customer c , ShoppingCart shoppingCart) {
        System.out.println("Order has been placed successfully!");
        order.status = ORDER_STATUS.PLACED;
        order.setCurrentState( order.shippedState );

        return new Invoice( c , order , shoppingCart.getTotal() );
    }

    @Override
    public void shipOrder() {
        System.out.println("Order will be shipped !!");
    }

    @Override
    public void cancelOrder() {
        order.status = ORDER_STATUS.CANCELLED;
        System.out.println("Order is cancelled !!");
        order.setCurrentState( null );

    }

    @Override
    public void deliverOrder() {
        System.out.println("Order is yet to be shipped !!");
    }
}