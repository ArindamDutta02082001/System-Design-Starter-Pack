package StatePattern.ATM.other_entity;

public class ATM {

    Double cashPresent;
    String _id;


    // no of 500 , 200 , 100 rs notes

    public Integer noOf500;
    public Integer noOf200;
    public Integer noOf100;


    public Integer totalAmt ;



    public ATM( String id , Double cashPresent , Integer noOf500 , Integer noOf200 , Integer noOf100  )
    {
        this._id = id;
        this.cashPresent = cashPresent;

        //
        this.noOf100 = noOf100;
        this.noOf200 = noOf200;
        this.noOf500 = noOf500;

        totalAmt = noOf100*100 + noOf100*200 + noOf100*500 ;
    }
    
}
