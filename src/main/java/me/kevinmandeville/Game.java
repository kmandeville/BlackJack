package me.kevinmandeville;

import java.util.ArrayList;
import java.util.List;
import me.kevinmandeville.core.Cardable;
import me.kevinmandeville.core.Dealer;
import me.kevinmandeville.core.Deck;
import me.kevinmandeville.core.Player;
import me.kevinmandeville.core.Shoe;

/**
 * @author kmandeville
 */
public class Game {

    public static final int NUMBER_OF_DECKS_FOR_SHOE = 8;
    private Dealer dealer;
    private List<Player> players;
    private List<Cardable> allHands;
    private Shoe shoe;

    public Game(Dealer dealer, List<Player> players, Shoe shoe) {
        this.dealer = dealer;
        this.players = players;
        this.shoe = shoe;
        this.allHands = new ArrayList<>();
        this.allHands.addAll(players);
        this.allHands.add(dealer);
    }

    public void run() throws InterruptedException {
        this.setUpShoe();

        // Add a loop that checks a variable to see if still playing (Q for quit maybe)

        // Add applying a bet (@TODO)
        // loop around players and dealer until dealer has 2 cards
        while (dealer.getHand().size() < 2) {
            for (Cardable allHand : allHands) {
                // Deal one card each to player then dealer, then another card to player and then dealer
                allHand.takeCard(this.shoe.getNextCard());
                printGame(true, false);
                Thread.sleep(500);
            }
        }

        // If Dealer has an Ace showing, check if Dealer has blackjack
        if (dealer.getHand().isAceShowing()) {
            System.out.println("Insurance (Y/N)?");
            // Ask if players want insurance (@TODO)

            if (dealer.getHand().isBlackJack()) {
                System.out.println("Dealer has BLACKJACK! Dealer wins");
                printGame(false, true);
            }
        }

        // Pause for input loop
        //      show player total, ask if hit or stay
        //      deal card for hit, if under 21, loop again
        //      if 21, skip out of loop
        //      if over 21, player loses and is out of the game

        // Now it's dealers turn.
        //      loop until dealer is at total of 17 or greater
        //      If dealer total is 16 or below, has to take a hit
        //      If dealer is 17 or greater, stay.
    }

    private void setUpShoe() {
        // @TODO make number of decks configurable
        for (int i = 0; i < NUMBER_OF_DECKS_FOR_SHOE; i++) {
            Deck deck = Shuffler.shuffleDeck(new Deck());
            this.shoe.addDeck(deck);
        }
    }

    private void printGame(boolean clearScreen, boolean showDealerHoleCard) {
        if (clearScreen) {
            clearConsole();
        }
        System.out.println("Dealer:");
        System.out.println("=======");
        System.out.println(dealer.getHand().toString(showDealerHoleCard));
        System.out.println("\n\n\n");

        for (Player player : players) {
            System.out.println("Player " + player.getPlayerId());
            System.out.println("========");
            System.out.println(player.getHand());
            System.out.println("\n\n\n\n");
        }
    }

    private void clearConsole() {
        // Use ANSI escape codes to clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Shoe getShoe() {
        return shoe;
    }
}
