package com.lld.notification.decorator;

public class CheeseCoffeeDecorator implements IBaseDecorator{   // yha pe IBaseCoffee bhi chlega

    public IBaseCoffee baseCoffee;
    public CheeseCoffeeDecorator( IBaseCoffee baseCoffee)
    {
        this.baseCoffee = baseCoffee;
    }


    @Override
    public String getName() {
        return "cheeze "+baseCoffee.getName();
    }

    @Override
    public double getPrice() {
        return baseCoffee.getPrice()+10.0;
    }
}
