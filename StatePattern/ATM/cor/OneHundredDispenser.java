package StatePattern.ATM.cor;

import StatePattern.ATM.other_entity.ATM;

public class OneHundredDispenser implements DispenseAmount {
    
    public DispenseAmount dispenseAmount;
    public Double amt ;

    public OneHundredDispenser(DispenseAmount dispenseAmount)
    {
        this.dispenseAmount = dispenseAmount;
    }

    @Override
    public void dispense(Double remainingAmt ,ATM atm) {

        // check 500s and pass the rest

        
        if(remainingAmt == 0)
        {
        return;
        }

        int notesReq = Math.min((int) (remainingAmt/100) , atm.noOf100 );
        Double rem = (double) (remainingAmt - notesReq*100);

         System.out.println(" 100 x "+notesReq);

        // dispenseAmount.dispense(rem,atm);

       
    }
}
