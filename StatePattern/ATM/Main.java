package StatePattern.ATM;

import StatePattern.ATM.other_entity.ATM;
import StatePattern.ATM.other_entity.Card;
import StatePattern.ATM.other_entity.CardType;

public class Main {

    public static void main(String[] args) {
        System.out.println(" LLD of ATM ");

        // settin the atm and the card
        ATM atm = new ATM("1" , 200000.0 , 10 , 50 , 50 );
        Card card = new Card("1", "Amit", 10000.0, CardType.CREDIT, "1234");


        // making a context
        ATMMachineContextManager a = new ATMMachineContextManager();

        a.setATM(atm);
        a.setCard(card);

        // starting a txn
        a.enterCard();
        a.enterPinFn("1234");
        a.enterAmountFn(10000.0);
        a.dispenseFn();






    }
    
}
