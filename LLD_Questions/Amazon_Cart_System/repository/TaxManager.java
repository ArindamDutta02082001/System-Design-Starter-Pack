package repository;

import cor.tax_cor.CGST;
import cor.tax_cor.StateTax;

public class TaxManager {

    double totalTaxAmount;

    // defining all the tax components
    public StateTax stateTax;
    public CGST cgst;

    public TaxManager(){
        this.totalTaxAmount = 0.0;

        // forming the chain of responsibility
        this.stateTax = new StateTax(null);
        this.cgst = new CGST(stateTax);
    }

    public double calculateTotalTax(double amt) {

        return cgst.applyTax(amt);
    }




}
