package state;

import entities.Customer;
import entities.Invoice;
import entities.Order;
import entities.ShoppingCart;
import entities.enums.ORDER_STATUS;

public class ShippedOrderState  implements OrderState{

    Order order;
    public ShippedOrderState(Order order)    {
        this.order = order;
    }


    @Override
    public Invoice placeOrder( Customer c, ShoppingCart s) {
        System.out.println("Order is  being  shipped !!");
        return null;
    }

    @Override
    public void shipOrder() {
        System.out.println("Order is shipped successfully !!");
        order.status = ORDER_STATUS.IN_TRANSIT;
        order.setCurrentState(order.deliverState);
    }

    @Override
    public void cancelOrder() {
        order.status = ORDER_STATUS.CANCELLED;
        System.out.println("Order is cancelled !!");
        order.setCurrentState( null );
    }

    @Override
    public void deliverOrder() {
        System.out.println("Order is  being  shipped !!");
    }
}
