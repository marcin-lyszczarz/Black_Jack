package blackjack;

import java.util.ArrayList;

/**
 * Created by A&M on 29.01.2019.
 */
public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String playerName) {
        this.hand = new ArrayList<Card>();
        this.name = playerName;
    }

    public String getName() {
        return name;
    }

    public void addCardToHand(Card newCard) {
        hand.add(newCard);
}

    public int getHandSum() {
        int sumOfPoints = 0;
        int cardPoints = 0;
        int numberOfAces = 0;

        for (int i = 0; i < hand.size(); i++) {
            cardPoints = hand.get(i).getCardValue().getValue();

            if (cardPoints == 11) {
                numberOfAces++;
                sumOfPoints += 11;
            } else sumOfPoints += cardPoints;
        }
        while (sumOfPoints > 21 && numberOfAces > 0){
            sumOfPoints-=10;
            numberOfAces--;
        }
        return sumOfPoints;
    }

    public void printHand(boolean showFirstHand){

        System.out.println(name + ":");
        System.out.println(getHandText(showFirstHand));

        if (showFirstHand){
            System.out.println("Punkty: [" + getHandSum() + "] \n");
        }else
            System.out.println("Punkty: [?] \n");
    }

    public String getHandText (boolean showFirsHand){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hand.size(); i++){
            if (i == 0 && !showFirsHand){
                sb.append("\n[Ukryta karta]");
            }else {
                sb.append("\n" + hand.get(i).toString());
            }
        }
        return sb.toString();
    }

    public boolean checkIfBusted(){
        if (getHandSum() >= 22){
            return true;
        }else
            return false;

    }

}
