package repository;

import entities.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    Map<Integer, Customer> customerMap ;

    public CustomerManager( )
    {
        customerMap = new HashMap<Integer, Customer>();
    }

    // register customer
    public String registerCustomer( Customer customer )
    {
        if( customerMap.containsKey( customer.getCustomerId() ) )
            return "Customer already exists !!";

        customerMap.put( customer.getCustomerId(), customer );
        return " Customer registered successfully !!";
    }

    // deregister customer
    public String deregisterCustomer( Customer customer )
    {
        if( !customerMap.containsKey( customer.getCustomerId() ) )
            return "Customer does not exists !!";

        customerMap.remove( customer.getCustomerId() );
        return " Customer deregistered successfully !!";
    }

    // to get a particular customer
    public Customer getCustomer( Integer customerId )
    {
        return customerMap.get( customerId );
    }
}
