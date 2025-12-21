import entities.Customer;
import entities.Invoice;
import entities.Product;
import repository.OrderStateManager;
import strategy.payment_strategy.CreditCard;
import strategy.payment_strategy.PaymentStrategy;

public class Main {

    public static void main(String args[] )
    {
        System.out.println("Amazon Inventory + Cart system");


        // ************ actors **************
        // creating customers
        Customer c1 = new Customer(1 , "Arindam" , "arindam@email.com");
        Customer c2 = new Customer(2 , "Ayush" , "ayush@email.com");

        // products
        Product p1 = new Product( "Iphone 14"  , 1000.0);
        Product p2 = new Product("Samsung S23" , 2000.0);

        // ***************  linking the actors ***************
        // inventory
        AmazonService as = AmazonService.getInstance();

        as.inventoryManager.addProductToInventory(p1 , 10);
        as.inventoryManager.addProductToInventory(p2 , 5);

        // register customers
        as.customerManager.registerCustomer(c1);
        as.customerManager.registerCustomer(c2);


        // ************* time for actions ***********

        // for customer c1
        // add products to cart :
        // adding p1 2 Qty , p2 1 Qty
        as.facadeAddProductToCart( c1.getCustomerId() , p1 );
        as.facadeAddProductToCart( c1.getCustomerId() , p1 );
        as.facadeAddProductToCart( c1.getCustomerId() , p2 );

        PaymentStrategy p = new CreditCard();
        as.setPaymentStrategy(p);

        Invoice inv = as.facadePlaceOrder( c1.getCustomerId() );
        // the order is in placed state now

        // the admin will ship and deliver the order
//        as.orderStateManager.cancelOrder();  // trying to cancel here should  work

        System.out.println("Invoice generated : "+inv);



        // now after order placing , admin will trigger the shipping and delivery
        as.shipAndDeliverOrder(new OrderStateManager());
//        as.orderStateManager.cancelOrder();  // trying to cancel here should not work



    }
    
}
