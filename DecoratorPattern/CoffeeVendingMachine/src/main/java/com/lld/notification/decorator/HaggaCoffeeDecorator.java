package com.lld.notification.decorator;

public class HaggaCoffeeDecorator implements IBaseDecorator{

    public IBaseCoffee baseCoffee;
    public HaggaCoffeeDecorator( IBaseCoffee baseCoffee)
    {
        this.baseCoffee = baseCoffee;
    }


    @Override
    public String getName() {
        return "hagga "+baseCoffee.getName();
    }

    @Override
    public double getPrice() {
        return baseCoffee.getPrice()+20.0;
    }
}
