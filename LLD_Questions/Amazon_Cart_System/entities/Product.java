package entities;

import java.util.UUID;

public class Product {

    private final String productId = UUID.randomUUID().toString();
    private String name;
    private double pricePerItem;

//    private boolean avaliable;   --> not using as of now

    public Product( String name, double price) {
        this.name = name;
        this.pricePerItem = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return pricePerItem;
    }

    public void setPrice(double price) {
        this.pricePerItem = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + pricePerItem;
    }
    
}
