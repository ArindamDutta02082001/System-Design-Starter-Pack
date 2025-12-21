package cor.tax_cor;

public class CGST implements Tax {

    Tax next;

    public CGST(Tax t) {
        this.next = t;
    }
    @Override
    public double applyTax(double amt) {
        if(next == null )
            return amt * 0.09;
        else
            return amt * 0.09 + next.applyTax(amt);
    }
}
