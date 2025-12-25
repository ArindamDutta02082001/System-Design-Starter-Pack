package state;

import entities.Customer;
import entities.Invoice;
import entities.ShoppingCart;

// this state pattern was introduced , as in Req.txt it is said that the
// Inventory will be handling the order created

public interface OrderState {

    // define the state functions
    public Invoice placeOrder(Customer c, ShoppingCart s);
    public void shipOrder();
    public void cancelOrder();

    public void deliverOrder();

}
