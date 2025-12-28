package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachine;

public class InsertCoinState implements States {

    VendingMachine vendingMachine;

    public InsertCoinState( VendingMachine vendingMachine)
    {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount )
    {
        System.out.println(" Coin inserted successfully !! ");
        vendingMachine.balance += amount;
        vendingMachine.setCurrState(vendingMachine.selectState);  // transferring the state
    }

    @Override
    public void pressButton(String buttonNumber)
    {
        System.out.println(" No coin inserted !!");
    }
    
    
    @Override
    public void dispenseItem()
    {
        System.out.println(" No coin inserted !!");

    }

    
}
