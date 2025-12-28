package StatePattern.ATM.entity;

import StatePattern.ATM.states.*;

public class ATM {

    Double cashPresent;
    String _id;


    // no of 500 , 200 , 100 rs notes

    public Integer noOf500;
    public Integer noOf200;
    public Integer noOf100;

    public Integer totalAmt ;


    // itna ka txn chaye
    public Double amtTxn = 0.0;



    // define your states  here
    public State InsertPinState ;
    public State InsertCardState ;
    public State InsertAmtState ;
    public State DispenseState ;


    public State currState ;



    public ATM( String id , Double cashPresent , Integer noOf500 , Integer noOf200 , Integer noOf100  )
    {
        this._id = id;
        this.cashPresent = cashPresent;

        //
        this.noOf100 = noOf100;
        this.noOf200 = noOf200;
        this.noOf500 = noOf500;

        totalAmt = noOf100*100 + noOf100*200 + noOf100*500 ;



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



}
