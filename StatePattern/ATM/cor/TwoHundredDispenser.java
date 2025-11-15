package StatePattern.ATM.cor;

import StatePattern.ATM.other_entity.ATM;

public class TwoHundredDispenser implements DispenseAmount {
    
    public DispenseAmount dispenseAmount;
   
    public Double amt ;

    public TwoHundredDispenser(DispenseAmount dispenseAmount)
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

       int notesReq = Math.min((int) (remainingAmt/200) , atm.noOf200 );
       Double rem = (double) (remainingAmt - notesReq*200);

         System.out.println(" 200 x "+notesReq);

        dispenseAmount.dispense(rem, atm);

       
    }
}
