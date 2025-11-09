package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachineContext;
import StatePattern.VendingMachin.inventory.Product;

public class DispenseInsertState implements States {

    public DispenseInsertState( VendingMachineContext vendingMachineContext )
    {
        
    }

    @Override
    public void insertCoin( VendingMachineContext vendingMachineContext , int amount )
    {
        System.out.println(" Item Dispensing...... !!");
    }
    
    @Override
    public void pressButton( VendingMachineContext vendingMachineContext , String buttonNumber)
    {
        System.out.println(" Item Dispensing...... !!");
    }
    
    
    @Override
    public void dispenseItem( VendingMachineContext vendingMachineContext)
    {
        System.out.println(" Item Dispensing...... !!");

        // after dispensing the item we need to update the inventory

        // now we already have the selected product
        Product sp = vendingMachineContext.selectedProduct;
        String buttonCode = vendingMachineContext.pressedButton;

        if( sp.quantity > 0 && sp.price <= vendingMachineContext.balance)
        {
            vendingMachineContext.balance -= sp.price;
            vendingMachineContext.inventory.updateProductQty(buttonCode, sp.quantity-1);
            System.out.println("Item is dispatched , please collect !!");
        }
        else if( sp.quantity <=0)
        System.out.println("The quantity is not enough !!");
        else 
        {
            System.out.println("Insufficient funds : avaliable : "+vendingMachineContext.balance+" required : "+sp.price );

        }

    }

    
}
