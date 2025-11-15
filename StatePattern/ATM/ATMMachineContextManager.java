package StatePattern.ATM;

import StatePattern.ATM.other_entity.ATM;
import StatePattern.ATM.other_entity.Card;
import StatePattern.ATM.states.*;

public class ATMMachineContextManager {


    // other entities to be initialized here
    public Card card;
    public ATM atm;

    // define your states
    public State InsertPinState ;
    public State InsertCardState ;
    public State InsertAmtState ;
    public State DispenseState ;


    public State currState ;


    // itna ka txn chaye
    public Double amtTxn = 0.0;



    public ATMMachineContextManager()
    {

        this.InsertPinState = new InsertPinState(this);
        this.InsertCardState = new InsertCardState(this);
        this.InsertAmtState = new InsertAmtState(this);
        this.DispenseState = new DispenseState(this);

        // settin the current state
        this.currState = InsertPinState;
    }


    // move to the next state
    public void setState( State state )
    {
        this.currState=state;
    }
    
    public void enterCard()
    {
        currState.insertCard(card);
    }

    public void enterPinFn( String pin )
    {
        currState.enterPin(pin);
    }

    public void enterAmountFn( Double amt)  // itna ka txn chaiye isko
    {
        this.amtTxn =amt;
        currState.enterAmt(amt);
    }

    public void dispenseFn()
    {
        currState.dispense();
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
