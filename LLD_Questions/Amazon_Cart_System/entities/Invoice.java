package entities;


// just to return the invoice after order is placed

public class Invoice {

    // It will be summation of the users and the orders and the final receipts

    Customer customer;
    public Order order;
    Double finalPrice;
    public String orderId ;

    public Invoice(Customer customer , Order order , Double amt) {

        this.customer = customer;
        this.finalPrice = amt;
        this.order = order;
        this.orderId = order.orderId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ", finalPrice=" + finalPrice +
                ", orderId=" + orderId +
                '}';
    }
}
