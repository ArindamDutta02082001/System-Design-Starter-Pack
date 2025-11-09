package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachineContext;

public class InsertCoinState implements States {

    VendingMachineContext vendingMachineContext;

    public InsertCoinState( VendingMachineContext vendingMachineContext )
    {
        this.vendingMachineContext = vendingMachineContext;
    }   

    @Override
    public void insertCoin( VendingMachineContext vendingMachineContext , int amount )
    {
        System.out.println(" Coin inserted successfully !! ");
        vendingMachineContext.balance += amount;
        vendingMachineContext.setCurrState( vendingMachineContext.selectState );  // trnasferring the state
    }

    @Override
    public void pressButton( VendingMachineContext vendingMachineContext , String buttonNumber)
    {
        System.out.println(" No coin inserted !!");
    }
    
    
    @Override
    public void dispenseItem( VendingMachineContext vendingMachineContext)
    {
        System.out.println(" No coin inserted !!");

    }

    
}
