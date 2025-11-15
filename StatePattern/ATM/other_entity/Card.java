package StatePattern.ATM.other_entity;

public class Card {
    
    public String _cardId;
    public String name;
    public Double amount;
    public String pin;
    public CardType cardType;

    public Card( String id , String name , Double amt , CardType cardType , String pin)
    {
        this._cardId = id;
        this.name = name;
        this.amount = amt;
        this.cardType = cardType;
        this.pin = pin;
    }
}
