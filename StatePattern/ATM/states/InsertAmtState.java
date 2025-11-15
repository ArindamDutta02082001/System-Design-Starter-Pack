package StatePattern.ATM.states;

import StatePattern.ATM.ATMMachineContextManager;
import StatePattern.ATM.other_entity.Card;

public class InsertAmtState implements State {
        ATMMachineContextManager next = null;

    public InsertAmtState( ATMMachineContextManager next)
    {
        this.next = next;
    }

    @Override
    public void insertCard(Card card) {

        
        System.out.println("Enter your amt......");
        
    }
    
    @Override
    public void enterPin(String pin) {
        System.out.println("Enter your amt......");
    }
    
    @Override
    public void enterAmt(Double amt) {

        System.out.println("Validating your amount ....Please wait !!");

        //int totalAmt = next.atm.noOf100*100 + next.atm.noOf100*200 + next.atm.noOf100*500 ; 

        if(next.atm.totalAmt < amt)
        {
            System.out.println(" We dont have that much funds.....");
        }
        else 
        {
            next.setState(next.DispenseState);
        }


        
    }
    
    @Override
    public void dispense() {
        System.out.println("Enter your amt......");
    }

}
