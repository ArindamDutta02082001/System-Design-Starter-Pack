package repository;


import entities.Customer;
import entities.Invoice;
import entities.ShoppingCart;
import state.DeliverOrderState;
import state.OrderState;
import state.PlacedOrderState;
import state.ShippedOrderState;

// so
public class OrderStateManager {

    // defining all the states
    public OrderState placeState;
    public OrderState shippedState;
    public OrderState deliverState;

    public OrderState currState = null;

    public OrderStateManager()
    {
        this.placeState = new PlacedOrderState(this);
        this.shippedState = new ShippedOrderState(this);
        this.deliverState = new DeliverOrderState(this);
        this.currState = placeState;

    }

    public void setCurrentState( OrderState orderState )
    {
        this.currState = orderState;
    }


    // methods to delegate the tasks to current state
    public Invoice placeOrder(Customer c , ShoppingCart s )
    {
        return currState.placeOrder(this , c , s);
    }

    public void shipOrder()
    {
        currState.shipOrder(this);
    }

    public void cancelOrder()
    {
        currState.cancelOrder(this);
    }

    public void deliverOrder()
    {
        currState.deliverOrder(this);
    }

}
