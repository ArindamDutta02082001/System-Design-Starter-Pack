package com.lld.notification;

import com.lld.notification.decorator.BaseCoffee;
import com.lld.notification.decorator.CheeseCoffeeDecorator;
import com.lld.notification.decorator.HaggaCoffeeDecorator;
import com.lld.notification.decorator.IBaseCoffee;

public class Main {

	public static void main(String[] args) {

		// creatign a coffe with toppings

		IBaseCoffee baseCoffee = new BaseCoffee("base-cofee" , 100.0);

		baseCoffee = new CheeseCoffeeDecorator(baseCoffee);
		baseCoffee = new HaggaCoffeeDecorator(baseCoffee);

		// 130 aana chaiye
		System.out.println("Final Coffee : "+baseCoffee.getName()+" price : "+baseCoffee.getPrice());

	}

}
