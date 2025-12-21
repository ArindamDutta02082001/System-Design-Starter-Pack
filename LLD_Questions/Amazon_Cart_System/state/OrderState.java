package state;

import entities.Customer;
import entities.Invoice;
import entities.ShoppingCart;
import repository.OrderStateManager;

// this state pattern was introduced , as in Req.txt it is said that the
// Inventory will be handling the order created

public interface OrderState {

    // define the state functions
    public Invoice placeOrder(OrderStateManager orderStateManager, Customer c, ShoppingCart s);
    public void shipOrder(OrderStateManager orderStateManager);
    public void cancelOrder(OrderStateManager orderStateManager);

    public void deliverOrder(OrderStateManager orderStateManager);

}
