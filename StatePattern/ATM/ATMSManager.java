package StatePattern.ATM;

import StatePattern.ATM.entity.ATM;
import StatePattern.ATM.entity.Card;

public class ATMSManager {


    // other entities to be initialized here
    public Card card;
    public ATM atm;






    public ATMSManager()
    {


    }




    // other utility fns to initialize the ATM cards etc
    public void setATM( ATM atm )
    {
        this.atm = atm;
    }

    public void setCard( Card card)
    {
        this.card = card;
    }
    
}
