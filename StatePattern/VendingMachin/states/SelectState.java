package StatePattern.VendingMachin.states;


import StatePattern.VendingMachin.VendingMachineContext;
import StatePattern.VendingMachin.inventory.Product;

public class SelectState implements States {

    VendingMachineContext vendingMachineContext;

    public SelectState( VendingMachineContext vendingMachineContext )
    {
        this.vendingMachineContext = vendingMachineContext;
    }

    @Override
    public void insertCoin( VendingMachineContext vendingMachineContext , int amount )
    {
        System.out.println(" coin already inserted , please select an item for a balance of : "+ vendingMachineContext.balance );
    }
    
    @Override
    public void pressButton( VendingMachineContext vendingMachineContext , String buttoncode )
    {
        System.out.println("Please select an item for a balance of : "+ vendingMachineContext.balance );
        
        // we need to validate the balance and update the inventory accordingly

        if( vendingMachineContext.inventory.getProduct(buttoncode) != null )
        {
            Product sp = vendingMachineContext.inventory.getProduct(buttoncode); 
            System.out.println(" Item selection .......... ");
            vendingMachineContext.selectProduct( sp);
            vendingMachineContext.pressedButton = buttoncode;
            vendingMachineContext.setCurrState( vendingMachineContext.dispenseInsertState );
            System.out.println(" your item : "+ sp.name+" will be selected ");

        }
        else
        {
            System.out.println("Item cannot be selected , item is not there in inventory !!");
        }          
        
    }
    
    
    @Override
    public void dispenseItem( VendingMachineContext vendingMachineContext)
    {
        System.out.println(" coin already inserted , please select an item for a balance of : "+ vendingMachineContext.balance );

    }

    
}
