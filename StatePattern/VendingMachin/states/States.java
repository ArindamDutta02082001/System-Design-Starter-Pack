package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachine;

public interface States {

    // all the functions that you will write here has to be common to all the states
    // else ISP will be violated

    // our vening machine will have 4 states : noCoinState --> insertCoinState --> itemSelectedState --> dispenseItemState

    public void insertCoin(int amount );
    public void pressButton(String buttonNumber);
    public void dispenseItem();

    
}
