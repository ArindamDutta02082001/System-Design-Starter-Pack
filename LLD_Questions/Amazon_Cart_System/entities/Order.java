package entities;

import entities.enums.CATEGORY;
import entities.enums.ORDER_STATUS;
import state.DeliverOrderState;
import state.OrderState;
import state.PlacedOrderState;
import state.ShippedOrderState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    public final String orderId = UUID.randomUUID().toString();
    public final Integer userId;
    public final List<CartItem> items;

    public ORDER_STATUS status;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime deliveredAt;

    public String deliveryAddress;
    public CATEGORY category;


    // defining all the states
    public OrderState placeState;
    public OrderState shippedState;
    public OrderState deliverState;

    public OrderState currState = null;


    public Order(Integer userId, List<CartItem> items , String Address , CATEGORY category) {
        this.userId = userId;
        this.items = items;
        this.deliveryAddress =Address;
        this.category = category;


        this.placeState = new PlacedOrderState(this);
        this.shippedState = new ShippedOrderState(this);
        this.deliverState = new DeliverOrderState(this);
        this.currState = placeState;

    }

    // set delivery date after delivered
    public void setDeliveredAt( LocalDateTime localDateTime)
    {
        this.deliveredAt = localDateTime;
    }



    // State Pattern

    public void setCurrentState( OrderState orderState )
    {
        this.currState = orderState;
    }


    // methods to delegate the tasks to current state
    public Invoice placeOrder(Customer c , ShoppingCart s )
    {
        return currState.placeOrder(c , s);
    }

    public void shipOrder()
    {
        currState.shipOrder();
    }

    public void cancelOrder()
    {
        currState.cancelOrder();
    }

    public void deliverOrder()
    {
        currState.deliverOrder();
    }
}
