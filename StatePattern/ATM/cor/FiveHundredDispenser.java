package StatePattern.ATM.cor;

import StatePattern.ATM.other_entity.ATM;


public class FiveHundredDispenser implements DispenseAmount {

    public DispenseAmount dispenseAmount;
    public Double amt ;

    public FiveHundredDispenser(DispenseAmount dispenseAmount)
    {
        this.dispenseAmount = dispenseAmount;
    }

    @Override
    public void dispense(Double remainingAmt , ATM atm) {

        // check 500s and pass the rest

        if(remainingAmt == 0)
        {
        return;
        }


        int notesReq = Math.min((int) (remainingAmt/500) , atm.noOf500 );
        Double rem = (double) (remainingAmt - notesReq*500);

        System.out.println(" 500 x "+notesReq);

        dispenseAmount.dispense(rem, atm);

       
    }
    
}
