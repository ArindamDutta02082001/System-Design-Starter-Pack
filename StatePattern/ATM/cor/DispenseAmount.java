package StatePattern.ATM.cor;

import StatePattern.ATM.entity.ATM;

// this COR will be used inside the dispense state class 

public interface DispenseAmount {
    
    public void dispense(Double remainingAmt , ATM atm );

}
