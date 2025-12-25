import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import entities.*;
import entities.enums.CATEGORY;
import repository.*;
import state.OrderState;
import strategy.discount_strategy.DiscountEngine;
import strategy.payment_strategy.PaymentStrategy;

public class AmazonService {


    // now registering all the other managers (manager + services)
    // later in MVC , we need to segregate the services and repository layer

    Map<Integer, List<Order>> userOrders;   // you can create a separate Order manager or this

    CartManager cartManager ;

    public InventoryManager inventoryManager;

    CustomerManager customerManager;

//    OrderStateManager orderStateManager;    heavily wrong

    PaymentStrategy paymentStrategy;

    TaxManager taxManager;

    DiscountEngine discountEngine;

    // singleton instance of Amazon repository
    
    private static AmazonService amazonService  = null ;

    private AmazonService()
    {

        // initialize all the managers
        cartManager = new CartManager();
        inventoryManager = new InventoryManager();
        customerManager = new CustomerManager();
        taxManager = new TaxManager();
        discountEngine = new DiscountEngine();
        this.userOrders = new HashMap<>();

        if( amazonService != null )
        {
            try {
                throw new IOException("Instance is already created !!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static AmazonService getInstance()
    {
        if( amazonService == null )
        {
        synchronized(AmazonService.class)
        {
        if( amazonService == null )
            amazonService = new AmazonService();
        }
        }

        return amazonService;
    }

    // customer utility methods

    // register and deregister methods again not doing
    // in interview please do


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    // add remove products to Carts
    public void facadeAddProductToCart(Integer userID , Product p )
    {
        cartManager.addProductToShoppingCart(userID , p);
        inventoryManager.addProductToInventory( p , 1);
    }

    public void facadeRemoveProductFromCart( Integer userID , Product p )
    {
        cartManager.removeProductToShoppingCart(userID , p);
        inventoryManager.removeProductToInventory( p , 1);
    }



    // creating facade Place Order method
    public Invoice facadePlaceOrder(Integer userID, String address , CATEGORY category)
    {
        // get the cart items for the user from cart manager
        ShoppingCart shoppingCart = cartManager.getCart( userID );

        // calculate total amount
        Double total = cartManager.getTotalCartValue( userID );

        // now few steps
        // calc the tax and the discounts if any

        double taxAmount = taxManager.calculateTotalTax( total );
        double maxDiscount = discountEngine.applyBestCoupon( shoppingCart );

        Order order = new Order( userID , shoppingCart.getItems() , address , category);
        userOrders
                .computeIfAbsent(userID, k -> new ArrayList<>())
                .add(order);

        // setting the order to placed state
        Invoice inv = order.placeOrder(customerManager.getCustomer(userID) , shoppingCart);


        // call payment strategy to pay the amount
        paymentStrategy.pay( total+taxAmount - maxDiscount );

        // clear the cart
        cartManager.clearCart( userID );

        return inv;
    }

     public Boolean facadeCancelOrder( Integer userID , String orderId )
     {
         if(!userOrders.containsKey(userID)) return false;

         Order o = userOrders.get(userID).stream().filter( e -> Objects.equals(e.orderId, orderId)).toList().get(0);
         o.cancelOrder();

         List<Order> items = userOrders.get(userID).stream().filter( e -> !Objects.equals(e.orderId, orderId)).toList();
        userOrders.put(userID , items);

        System.out.println( orderId +" cancelled for user :"+userID);

        return true;
     }

    
}
