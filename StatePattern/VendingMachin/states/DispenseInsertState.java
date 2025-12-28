package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachine;
import StatePattern.VendingMachin.entity.Product;

public class DispenseInsertState implements States {

    VendingMachine vendingMachine;

    public DispenseInsertState( VendingMachine vendingMachine)
    {
        this.vendingMachine =vendingMachine;
    }

    @Override
    public void insertCoin(int amount )
    {
        System.out.println(" Item Dispensing...... !!");
    }
    
    @Override
    public void pressButton(String buttonNumber)
    {
        System.out.println(" Item Dispensing...... !!");
    }
    
    
    @Override
    public void dispenseItem()
    {
        System.out.println(" Item Dispensing...... !!");

        // after dispensing the item we need to update the VMOneInventory

        // now we already have the selected product
        Product sp = vendingMachine.selectedProduct;
        String buttonCode = vendingMachine.pressedButton;

        if( sp.quantity > 0 && sp.price <= vendingMachine.balance)
        {
            vendingMachine.balance -= sp.price;
            vendingMachine.updateProductQty(buttonCode, sp.quantity-1);
            System.out.println("Item is dispatched , please collect !!");
        }
        else if( sp.quantity <=0)
        System.out.println("The machine quantity is not enough !!");
        else 
        {
            System.out.println("Insufficient funds : avaliable : "+ vendingMachine.balance+" required : "+sp.price );

        }

    }

    
}
