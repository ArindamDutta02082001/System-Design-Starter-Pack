package repository;

import entities.Product;
import entities.ShoppingCart;
import java.util.HashMap;
import java.util.Map;

public class CartManager {

    // mapping the Cart Item for a user

    Map<Integer , ShoppingCart> userCarts;     // user vs Cart

    public CartManager( )
    {
        this.userCarts = new HashMap<>();
    }


    public void addProductToShoppingCart( Integer userID , Product p )
    {
        ShoppingCart cart = userCarts.getOrDefault( userID , new ShoppingCart( userID ) );
        cart.addProduct( p , 1 );
        userCarts.put( userID , cart );
    }

    public void removeProductToShoppingCart( Integer userID , Product p )  // remove i product qty from cart
    {
        ShoppingCart cart = userCarts.getOrDefault( userID , new ShoppingCart( userID ) );
    }

    // get all the cart items for a user
    public ShoppingCart getCart( Integer userID )
    {
        return userCarts.getOrDefault( userID , null);
    }

    // get total cart value
    public Double getTotalCartValue( Integer userID )
    {
        return userCarts.getOrDefault( userID , new ShoppingCart( userID ) ).getTotal();
    }

    // clear cart for user
    public void clearCart( Integer userID )
    {
        userCarts.remove( userID );
    }

}
