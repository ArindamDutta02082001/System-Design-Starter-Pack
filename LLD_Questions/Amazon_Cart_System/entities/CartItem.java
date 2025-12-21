package entities;

import java.util.UUID;

public class CartItem {

    private String CartItemId = UUID.randomUUID().toString();
    private Product product;
    private Double totalPrice;
    private Integer qtyOfProduct;



    public CartItem( Product product, Integer qtyOfProduct) {
        this.product = product;
        this.qtyOfProduct =qtyOfProduct;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    // utility methods
    public Double getTotalPrice() {
        return qtyOfProduct*product.getPrice();
    }
    public Integer getQuantity() {
        return qtyOfProduct;
    }

    public void setQuantity( int qty ) {
        this.qtyOfProduct += qty;
    }
    
}
