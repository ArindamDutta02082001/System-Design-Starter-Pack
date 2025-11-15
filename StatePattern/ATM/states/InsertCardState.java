package StatePattern.ATM.states;

import StatePattern.ATM.ATMMachineContextManager;
import StatePattern.ATM.other_entity.Card;

public class InsertCardState implements State {
    
    ATMMachineContextManager next = null;

    public InsertCardState( ATMMachineContextManager next)
    {
        this.next = next;
    }

    @Override
    public void insertCard(Card card) {

        // we can create a list of accnt in the atm class and iterate here to check if the card name matchn in the list
        System.out.println("Card inserted enter pin....");
       
        // pass to the next state
        next.setState(next.InsertPinState);
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Please insert your card ....");
    }
    
    @Override
    public void enterAmt(Double amt) {
        System.out.println("Please insert your card ....");
    }
    
    @Override
    public void dispense() {
        System.out.println("Please insert your card ....");
    }

}
