package entities;

public class Customer
{
    private String name;
    private Integer customerId;

    // for the observer pattern
    private String email;


    public Customer(Integer id , String name, String email) {
        this.customerId = id;
        this.name = name;
        this.email = email;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}