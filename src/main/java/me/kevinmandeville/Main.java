package me.kevinmandeville;

import java.math.BigDecimal;
import java.util.List;
import me.kevinmandeville.core.Dealer;
import me.kevinmandeville.core.Player;
import me.kevinmandeville.core.Shoe;

public class Main {

    public static void main(String[] args) {
        // Set up Game
        Player mainPlayer = new Player(1, "Player 1", new BigDecimal("10000"));
        Dealer dealer = new Dealer();
        Shoe newShoe = new Shoe();
        Game game = new Game(dealer, List.of(mainPlayer), newShoe);
        try {
            game.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        Deck deck = new Deck();
//
//        System.out.println("In order:");
//        System.out.println(deck);
//
//        Shuffler shuffler = new Shuffler();
//        Deck shuffledDeck = shuffler.shuffleDeck(deck);
//
//        System.out.println("Shuffled: ");
//        System.out.println(shuffledDeck);
    }
}