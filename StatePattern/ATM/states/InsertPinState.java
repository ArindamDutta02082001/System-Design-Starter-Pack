package StatePattern.ATM.states;

import StatePattern.ATM.ATMMachineContextManager;
import StatePattern.ATM.other_entity.Card;

public class InsertPinState implements State {

    ATMMachineContextManager next = null;

    public InsertPinState( ATMMachineContextManager next)
    {
        this.next = next;
    }

    @Override
    public void insertCard(Card card) {
       System.out.println("Card already inserted ...... Enter PIN ");
    }
    
    @Override
    public void enterPin(String pin) {
        
        // vlaidating the entered pin from user
        if( next.card.pin.equals(pin))
        {
            System.out.println("User authenticated ...... Enter amount ");
            next.setState(next.InsertAmtState);
        }
        else 
        {
            System.out.println("Incorreect PIN");
        }
       
    }

    @Override
    public void enterAmt(Double amt) {
        System.out.println("Card already inserted ...... Enter PIN ");
    }

    @Override
    public void dispense() {
       System.out.println("Card already inserted ...... Enter PIN ");
    }
    
}
