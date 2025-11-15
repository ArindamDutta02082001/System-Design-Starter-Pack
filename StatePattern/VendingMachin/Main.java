package StatePattern.VendingMachin;

import StatePattern.VendingMachin.inventory.Product;

public class Main {


    public static void main(String[] args) {
        
        VendingMachineContext vendingMachineContext = new VendingMachineContext();
        // a vending machine and an associated inventory is created with it



        // admins will be putting the products into the inventory

        Product coke = new Product( "Coke" ,  10 , 5 );
        Product pepsi = new Product( "Pepsi" , 15 , 5 );
        Product chips = new Product( "Chips" , 20 , 5 );
        Product chocolate = new Product( "Chocolate" , 25 , 5  );

        vendingMachineContext.addItemToInventory( "A1" , coke );
        vendingMachineContext.addItemToInventory( "A2" , pepsi );   
        vendingMachineContext.addItemToInventory( "B1" , chips );
        vendingMachineContext.addItemToInventory( "B2" , chocolate );


        // simulating the vending machine operations by the user
        
        // transaction 1
        vendingMachineContext.insertCoin(10);
        vendingMachineContext.pressButtonToSelectItem("A1");
        vendingMachineContext.dispenseItem();

        System.out.println("**************************Resetting the context...........................................");
        vendingMachineContext.resetVendingMachineContext();

        // transaction 2
        vendingMachineContext.insertCoin(10);
        vendingMachineContext.pressButtonToSelectItem("B2");  // b2 chocolate price = 25 not possible
        vendingMachineContext.dispenseItem();


    }
    
}
