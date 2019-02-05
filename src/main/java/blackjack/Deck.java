package blackjack;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by A&M on 29.01.2019.
 */
public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();

        for (int suit = 0; suit <=3; suit++){
            for (int value = 0; value <= 12; value++){
                cards.add(new Card(Suit.values()[suit], Value.values()[value]));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card handOutCard(){
        return cards.remove(0);

    }
}
