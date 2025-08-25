package Service;


import java.io.IOException;
import java.util.*;
import Entities.*;

public class AmazonService {

    // to store the Customers 
    HashMap<String, Customer> customerDB;

    // to store the Products
    HashMap<String, Product> productDB; 


    // utility functions
    public String registerCustomer( Customer customer )
    {
        if( customerDB.containsKey(customer.getCustomerId()))
        return "Already Exists";

        customerDB.put(customer.getCustomerId(), customer);
        return " Successfully registered customer !!!";

    }

    public String registerProduct( Product product )
    {
        if( productDB.containsKey(product.getProductId()))
        return "Already Exists";

        productDB.put(product.getProductId(), product);
        return " Successfully registered product !!!";

    }

    public Product getProduct( String productId )
    {
        return productDB.getOrDefault(productId, null);
    }

    // singleton instance of Amazon Service
    
    private static AmazonService amazonService  = null ;

    private AmazonService()
    {
        if( amazonService != null )
        {
            try {
                throw new IOException("Instence is already created !!");
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
    
}
