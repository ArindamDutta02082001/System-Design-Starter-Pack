package StatePattern.VendingMachin.inventory;

public class Product {

    public String name;
    public Integer price;
    public Integer quantity;

    public Product ( String name , Integer price , Integer quantity )
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
        
}
