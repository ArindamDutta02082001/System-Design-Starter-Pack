package StatePattern.ATM.states;

import StatePattern.ATM.other_entity.Card;

public interface State {
    
    // define the state functions
    public void insertCard( Card card);
    public void enterPin(String pin);
    public void enterAmt( Double amt);
    public void dispense();

}
