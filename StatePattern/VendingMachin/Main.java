package StatePattern.VendingMachin;

import StatePattern.VendingMachin.entity.Product;

public class Main {


    public static void main(String[] args) {
        
        VendingMachine vendingMachine = new VendingMachine();
        // a vending machine and an associated VMOneInventory is created with it

        
        // admins will be putting the products into the VMOneInventory

        Product coke = new Product( "Coke" ,  10 , 5 );
        Product pepsi = new Product( "Pepsi" , 15 , 5 );
        Product chips = new Product( "Chips" , 20 , 5 );
        Product chocolate = new Product( "Chocolate" , 25 , 5  );

        vendingMachine.addProduct( "A1" , coke );
        vendingMachine.addProduct( "A2" , pepsi );
        vendingMachine.addProduct( "B1" , chips );
        vendingMachine.addProduct( "B2" , chocolate );


        // simulating the vending machine operations by the user
        
        // transaction 1
        vendingMachine.insertCoin(10);
        vendingMachine.pressButtonToSelectItem("A1");
        vendingMachine.dispenseItem();

        System.out.println("**************************Resetting the context...........................................");
        vendingMachine.resetVendingMachineContext();

        // transaction 2
        vendingMachine.insertCoin(10);
        vendingMachine.pressButtonToSelectItem("B2");  // b2 chocolate price = 25 not possible
        vendingMachine.dispenseItem();


    }
    
}
