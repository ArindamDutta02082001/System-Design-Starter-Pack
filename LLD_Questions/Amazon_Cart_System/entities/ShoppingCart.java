package entities;


// a very critical entity of abstractions
// each user will have a shopping cart

// here we will store the list of cart items for a user
// else in the cart manager we can also maintain a map of user vs list of cart items


import java.util.*;

public class ShoppingCart {

    private Integer userId;
    private final Map<String, CartItem> items = new HashMap<>(); // productId vs CartItem

    public ShoppingCart(Integer userId) {
        this.userId = userId;
    }

    public synchronized void addProduct(Product p, int qty) {
        items.compute(p.getProductId(), (k, v) -> {
            if (v == null) return new CartItem(p, qty);
            v.setQuantity(qty);
            return v;
        });
    }

    public synchronized void removeProduct(Product p) {

        if( items.containsKey(p.getProductId()) )
        {
            CartItem item = items.get( p.getProductId() );
            if( item.getQuantity() > 1 )
            {
                item.setQuantity( -1 );   // reduce qty by 1
            }
            else
            {
                items.remove( p.getProductId() );
            }
        }

    }

    public synchronized List<CartItem> getItems() {
        return Collections.unmodifiableList(
                new ArrayList<>(items.values()));
    }

    public synchronized double getTotal() {
        return items.values()
                .stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
