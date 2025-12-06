package Entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CartItem {

    private String CartItemId;
    private Product product;
    private Double totalPrice;
    private LocalDate DateOfPurchase;
    private Integer quantity;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateOfPurchase() {
        return DateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        DateOfPurchase = dateOfPurchase;
    }

    public CartItem(String cartItemId, Product product, Double totalPrice , LocalDate dateOfPurchase , Integer quantity) {
        this.CartItemId = cartItemId;
        this.product = product;
        this.totalPrice = totalPrice;
        this.DateOfPurchase = dateOfPurchase;
        this.quantity =quantity;
    }

    public String getCartItemId() {
        return CartItemId;
    }
    public void setCartItemId(String cartItemId) {
        CartItemId = cartItemId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
