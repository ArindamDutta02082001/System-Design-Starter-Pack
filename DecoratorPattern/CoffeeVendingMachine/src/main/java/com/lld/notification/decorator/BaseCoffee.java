package com.lld.notification.decorator;

public class BaseCoffee implements IBaseCoffee{

    public String name;
    public double price;

    public BaseCoffee( String name , double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName( ){
        return this.name;
    }
    public double getPrice()
    {
        return this.price;
    }
}
