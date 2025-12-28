package StatePattern.VendingMachin.states;


import StatePattern.VendingMachin.VendingMachine;
import StatePattern.VendingMachin.entity.Product;

public class SelectState implements States {

    VendingMachine vendingMachine;

    public SelectState( VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount )
    {
        System.out.println(" coin already inserted , please select an item for a balance of : "+ vendingMachine.balance );
    }
    
    @Override
    public void pressButton(String buttoncode )
    {
        System.out.println("Please select an item for a balance of : "+ vendingMachine.balance );
        
        // we need to validate the balance and update the VMOneInventory accordingly

        if( vendingMachine.getProduct(buttoncode) != null )
        {
            Product sp = vendingMachine.getProduct(buttoncode);
            vendingMachine.pressedButton = buttoncode;
            System.out.println(" Item selection .......... ");
            vendingMachine.selectProduct( sp);
            vendingMachine.setCurrState( vendingMachine.dispenseInsertState );
            System.out.println(" your item : "+ sp.name+" will be selected ");

        }
        else
        {
            System.out.println("Item cannot be selected , item is not there in VMOneInventory !!");
        }          
        
    }
    
    
    @Override
    public void dispenseItem()
    {
        System.out.println(" coin already inserted , please select an item for a balance of : "+ vendingMachine.balance );

    }

    
}
