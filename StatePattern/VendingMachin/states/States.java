package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachineContext;

public interface States {

    // all the functions that you will write here has to be common to all the states
    // else ISP will be violated

    // our vening machine will have 4 states : noCoinState --> insertCoinState --> itemSelectedState --> dispenseItemState

    public void insertCoin( VendingMachineContext vendingMachineContext , int amount );
    public void pressButton( VendingMachineContext vendingMachineContext , String buttonNumber);
    public void dispenseItem( VendingMachineContext vendingMachineContext); 

    
}
