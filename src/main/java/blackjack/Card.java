package blackjack;

/**
 * Created by A&M on 29.01.2019.
 */
public class Card {

    private Suit cardSuit;
    private Value cardValue;

    public Card(Suit suit, Value value){
        cardSuit = suit;
        cardValue = value;
    }

    public Value getCardValue(){
        return cardValue;
    }

    public Suit getCardSuit(){
        return cardSuit;
    }

    @Override
    public String toString() {
        return cardValue.toString() + " " + cardSuit.toString();
    }
}
