package cor.tax_cor;

public class StateTax implements Tax {

    Tax next;

    public StateTax(Tax t ) {
        this.next = t;
    }

    @Override
    public double applyTax(double amt) {
        if(next == null )
            return amt*0.1;
        else
             return amt*0.1 + next.applyTax(amt);
    }

    // same for the state tax as well

    // make an api call to the DB for a particular city tax
    // as it is not possible to store the 1506 cities of India


    // for now , we will hardcode the city tax as 0.1


}
