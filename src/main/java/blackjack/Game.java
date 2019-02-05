package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by A&M on 29.01.2019.
 */
public class Game {
    Scanner scanner;
    Deck deck;
    Player player;
    Player dealer;

    public Game() {
        scanner = new Scanner(System.in);
        deck = new Deck();
        deck.shuffle();

        player = new Player("Ja");
        dealer = new Player("Komputer");
    }

    public void runGame() {
        System.out.println("BLACK JACK GAME");

        player.addCardToHand(deck.handOutCard());
        dealer.addCardToHand(deck.handOutCard());

        player.addCardToHand(deck.handOutCard());
        dealer.addCardToHand(deck.handOutCard());

        System.out.println();

        player.printHand(true);
        dealer.printHand(false);


        boolean playerInGame = true;
        boolean dealerInGame = true;
        String answer;

        while (playerInGame || dealerInGame) {
            if (playerInGame) {
                System.out.println("Dobrać kartę ? (T/N)?");
                answer = scanner.next();

                if (answer.compareToIgnoreCase("T") == 0) {
                    System.out.println("\n Dobierasz kartę \n");

                    player.addCardToHand(deck.handOutCard());
                    playerInGame = !player.checkIfBusted();
                    player.printHand(true);
                } else {
                    System.out.println("Nie dobierasz karty");
                    playerInGame = false;
                }

            }
            if (dealerInGame) {
                if (dealer.getHandSum() < 17) {

                    System.out.println("Krupier dobiera kartę");
                    dealer.addCardToHand(deck.handOutCard());
                    dealerInGame = !dealer.checkIfBusted();
                    dealer.printHand(false);
                }
                else {
                    System.out.println("Krupier nie dobiera karty");
                    dealerInGame = false;
                }
            }
        }
        scanner.close();

        System.out.println("Koniec gry");

        player.printHand(true);
        dealer.printHand(true);

        int playerSum = player.getHandSum();
        int dealerSum = dealer.getHandSum();

        if (playerSum > 21 && dealerSum > 21 || playerSum == dealerSum) {
            System.out.println("NIKT NIE WYGRAŁ");
        } else if (playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) {
            System.out.println("WYGRAŁEŚ");
        } else
            System.out.println("KOMPUTER WYGRAŁ");
    }
}
