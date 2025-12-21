package state;

import entities.Customer;
import entities.Invoice;
import entities.ShoppingCart;
import repository.OrderStateManager;

public class ShippedOrderState  implements OrderState{

    OrderStateManager orderStateManager;
    public ShippedOrderState(OrderStateManager orderStateManager)    {
        this.orderStateManager = orderStateManager;
    }


    @Override
    public Invoice placeOrder(OrderStateManager orderStateManager, Customer c, ShoppingCart s) {
        System.out.println("Order is  being  shipped !!");
        return null;
    }

    @Override
    public void shipOrder(OrderStateManager orderStateManager) {
        System.out.println("Order is shipped successfully !!");
        orderStateManager.setCurrentState(orderStateManager.deliverState);
    }

    @Override
    public void cancelOrder(OrderStateManager orderStateManager) {
        orderStateManager.setCurrentState( null );
        System.out.println("Order is cancelled !!");
    }

    @Override
    public void deliverOrder(OrderStateManager orderStateManager) {
        System.out.println("Order is  being  shipped !!");
    }
}
