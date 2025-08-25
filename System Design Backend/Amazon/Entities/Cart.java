package Entities;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import Service.AmazonService;

public class Cart {

    private String cartId;
    private String customerId;
    private List<CartItem> cartItems;
    private double totalCartPrice;

    Character

    public Cart(String cartId, String customerId, List<CartItem> cartItems, double totalCartPrice) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.cartItems = cartItems;
        this.totalCartPrice = totalCartPrice;
    }

    public String getCartId() {
        return cartId;
    }
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public void setCartItems(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }
    public double getTotalCartPrice() {
        return totalCartPrice;
    }
    public void setTotalCartPrice(double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    // methods

    public synchronized String addItem( Product product, int quantity ) {
        
            for( int i=0;i<cartItems.size();i++)
            {
           
                // to cehck if already presnet then update the quantity
                if( cartItems.get(i).getProduct().getProductId().equals(product.getProductId()))
                {
                    cartItems.get(i).setQuantity(  cartItems.get(i).getQuantity() + quantity );
                    return " Updated Successfully !! ";
                }

            }

            // we will crete a new Product , set into CartItem and put into cart

            Product getProduct = AmazonService.getInstance().getProduct(product.getProductId());
            if( product != null || product.getAvaliable() == false )
            return " No Product Avaliable !!";

            Double totalPrice = product.getPrice() * quantity;
            CartItem cartItem = new CartItem(UUID.randomUUID().toString(), product , totalPrice ,LocalDate.now() , quantity);
 
            this.setCartItems(cartItem);

        return " Updated order Successfully !! ";

    }


      public synchronized void updateItem( Product product, int quantity ) {
        
            for( int i=0;i<cartItems.size();i++)
            {
                // to cehck if already presnet then update the quantity
                if( cartItems.get(i).getProduct().getProductId().equals(product.getProductId()))
                {
                    cartItems.get(i).setQuantity(  cartItems.get(i).getQuantity() + quantity );
                    return;
                }

            }

    }

    public synchronized void removeItem( String productId ) {

        List<Product> newList = new ArrayList<>();
        
            for( int i=0;i<cartItems.size();i++)
            {
                // to cehck if already presnet then update the quantity
                if( cartItems.get(i).getProduct().getProductId().equals(productId) == false )
                {
                    newList.add(cartItems.get(i).getProduct());
                }

            }

    }


    
}
