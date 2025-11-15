package StatePattern.ATM.cor;

import StatePattern.ATM.other_entity.ATM;

public interface DispenseAmount {
    
    public void dispense(Double remainingAmt , ATM atm );

}
