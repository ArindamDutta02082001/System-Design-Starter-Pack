package StatePattern.ATM.states;

import StatePattern.ATM.ATMMachineContextManager;
import StatePattern.ATM.cor.DispenseAmount;
import StatePattern.ATM.cor.FiveHundredDispenser;
import StatePattern.ATM.cor.OneHundredDispenser;
import StatePattern.ATM.cor.TwoHundredDispenser;
import StatePattern.ATM.other_entity.Card;

public class DispenseState implements State {
    
    ATMMachineContextManager next = null;

    public DispenseState( ATMMachineContextManager next)
    {
        this.next = next;
    }

    @Override
    public void insertCard(Card card) {

        
        System.out.println("Validating your amt......");
        
    }
    
    @Override
    public void enterPin(String pin) {
        System.out.println("Validating your amt......");
        
    }
    
    @Override
    public void enterAmt(Double amt) {
        
        System.out.println("Validating your amt......");
        
    }
    
    @Override
    public void dispense() {
        // dispense calc

        // formation of the linking
        DispenseAmount d1 = new OneHundredDispenser(null);
        DispenseAmount d2 = new TwoHundredDispenser(d1);
        DispenseAmount d3 = new FiveHundredDispenser(d2);

        d3.dispense(next.amtTxn, next.atm);

    }
}
