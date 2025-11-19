package StatePattern.VendingMachin.states;

import StatePattern.VendingMachin.VendingMachineContext;

public class StateFactory {

    // this class contains the initialization of the states 

    VendingMachineContext vc;

    public StateFactory( VendingMachineContext vc )
    {
        this.vc = vc;
    }

    public States getState( StateEnum StateEnum )
    {
        switch (StateEnum) {
            case INSERT_COIN_STATE:
                return new InsertCoinState(vc);
            case ITEM_SELECTED_STATE:
                return new SelectState(vc);
            case DISPENSE_ITEM_STATE:
                return new DispenseInsertState(vc);
            default:
                break;
        }

        return null;
    }
    
}
