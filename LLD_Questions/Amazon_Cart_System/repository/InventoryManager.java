package repository;

import entities.CartItem;
import entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {

    // our Dark Store Inventory
    Map<Product ,Integer> productDb;    //  Product vs qty --> if qty=0 , then pro

    public InventoryManager()
    {
        this.productDb = new HashMap<>();
    }

    public Boolean addProductToInventory( Product product , int qty)
    {
        productDb.put( product , productDb.getOrDefault(product,0)+1);
        return true;
    }

    public Boolean removeProductToInventory( Product product , int qty)
    {
        productDb.put( product , productDb.getOrDefault(product,0)-1);
        if( productDb.get(product) == 0 )
            productDb.remove(product);

        return true;
    }


}
