import java.io.IOException;

import entities.*;
import repository.*;
import state.OrderState;
import strategy.discount_strategy.DiscountEngine;
import strategy.payment_strategy.PaymentStrategy;

public class AmazonService {


    // now registering all the other managers (manager + services)
    // later in MVC , we need to segregate the services and repository layer

    CartManager cartManager ;

    public InventoryManager inventoryManager;

    CustomerManager customerManager;

    OrderStateManager orderStateManager;

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
        orderStateManager = new OrderStateManager();
        taxManager = new TaxManager();
        discountEngine = new DiscountEngine();

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



    // creating fascade Place Order method
    public Invoice facadePlaceOrder( Integer userID )
    {
        // get the cart items for the user from cart manager
        ShoppingCart shoppingCart = cartManager.getCart( userID );

        // calculate total amount
        Double total = cartManager.getTotalCartValue( userID );

        // now few steps
        // calc the tax and the discounts if any

        double taxAmount = taxManager.calculateTotalTax( total );
        double maxDiscoun = discountEngine.applyBestCoupon( shoppingCart );

        // setting the order to placed state
         Invoice inv = orderStateManager.placeOrder(customerManager.getCustomer(userID) , shoppingCart);


        // call payment strategy to pay the amount
        paymentStrategy.pay( total+taxAmount - maxDiscoun );

        // clear the cart
        cartManager.clearCart( userID );
        return inv;
    }

     public void facadeCancelOrder( )
     {
         orderStateManager.cancelOrder();
     }


    // admin methods , here I am not creating again inventory add and remove

    // inventory manager will trigger this
    public void shipAndDeliverOrder( OrderStateManager o )
    {
        orderStateManager.shipOrder();
        orderStateManager.deliverOrder();
    }


    
}
