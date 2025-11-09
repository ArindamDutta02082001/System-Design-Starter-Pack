package StatePattern.VendingMachin.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    // This will contain the mapping of the products


    // mapping of the product code to the product object
    Map<String, Product> productMap = new HashMap<>();

    public void addProduct( String code , Product p)
    {
        if(productMap.containsKey( code) == false )   // new product
        productMap.put( code , p);
    }

    // to update the qty of the product
    public void updateProductQty( String code , Integer qty)    
    {
        if(productMap.containsKey(code) == true )   // product exists
        productMap.get(code).quantity = qty;
        else 
        System.out.println(" Product does not exist !! ");
    }   

    // to get an item based on the button code
    public Product getProduct( String code )
    {
        if( productMap.containsKey( code) == true )
        return productMap.get( code);
        else 
            return null;
    }

    
}
