package me.kevinmandeville;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import me.kevinmandeville.core.Cardable;
import me.kevinmandeville.core.Dealer;
import me.kevinmandeville.core.Player;
import me.kevinmandeville.core.Shoe;
import me.kevinmandeville.strategy.HitOrStandStrategy;
import me.kevinmandeville.strategy.HitStandStrategyFactory;

/**
 * @author kmandeville
 */
public class Game {

    public static final int NUMBER_OF_DECKS_FOR_SHOE = 8;
    public static final int CARDS_LEFT_IN_SHOE_RESHUFFLE_POINT = 52;

    private static Game instance;
    private final Dealer dealer;
    private final List<Player> players;
    private final List<Cardable> allParticipants;
    private Shoe shoe;

    private Game(Dealer dealer, List<Player> players, Shoe shoe) {
        this.dealer = dealer;
        this.players = players;
        this.shoe = shoe;
        this.allParticipants = new ArrayList<>();
        this.allParticipants.addAll(players);
        this.allParticipants.add(dealer);
    }

    public static Game getInstance(Dealer dealer, List<Player> players, Shoe shoe) {
        if (instance == null) {
            instance = new Game(dealer, players, shoe);
        }
        return instance;
    }

    public static Game getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Game not instantiated. Call other constructor");
        }
        return instance;
    }

    public void run() throws InterruptedException {
        this.setUpShoe();
        String quit = "";
        try (Scanner scanner = new Scanner(System.in)) {
            // Add a loop that checks a variable to see if still playing (Q for quit maybe) (TODO)
            while (!quit.equalsIgnoreCase("Q")) {
                this.resetGame();
                // Add applying a bet (TODO)

                // do I need to reshuffle the shoe?
                if (shoe.size() < CARDS_LEFT_IN_SHOE_RESHUFFLE_POINT) {
                    this.setUpShoe();
                }

                // loop around players and dealer until dealer has 2 cards
                dealStartingCards();

                if (doesDealerHaveBlackJack()) {
                    // add insurance option TODO
                    System.out.println("Dealer has blackjack!");
                    return;
                }

                // Pause for input loop
                //      show player total, ask if hit or stay
                HitStandStrategyFactory factory = new HitStandStrategyFactory();
                for (Player player : players) {
                    HitOrStandStrategy strategy = factory.getStrategyInstance(player);
                    strategy.playHand(player, scanner);
                }

                // Now it's dealers turn.
                HitOrStandStrategy dealerStrategy = factory.getStrategyInstance(dealer);
                dealerStrategy.playHand(dealer, scanner);

                System.out.println("Any key to continue or Quit(Q):");
                quit = scanner.next();
            }
        }
    }

    private void resetGame() {
        for (Cardable allParticipant : allParticipants) {
            allParticipant.resetHand();
        }
    }

    private boolean doesDealerHaveBlackJack() {
        // If Dealer has an Ace showing, check if Dealer has blackjack
        if (dealer.getHand().isAceShowing()) {
            System.out.println("Insurance (Y/N)?");
            // Ask if players want insurance (TODO)

            if (dealer.getHand().isBlackJack()) {
                System.out.println("Dealer has BLACKJACK! Dealer wins");
                printGame(false, true);
                return true;
            }
        }
        return false;
    }

    private void dealStartingCards() throws InterruptedException {
        do {
            for (Cardable allHand : allParticipants) {
                // Deal one card each to player then dealer, then another card to player and then dealer
                allHand.takeCard(this.shoe.getNextCard());
                printGame(true, false);
                Thread.sleep(500);
            }
        } while (dealer.getHand().size() < 2);
    }

    private void setUpShoe() {
        this.shoe = new Shoe();
        this.shoe.init(NUMBER_OF_DECKS_FOR_SHOE);
        this.shoe = Shuffler.shuffleShoe(this.shoe, 5);
    }

    public void printGame(boolean clearScreen, boolean showDealerHoleCard) {
        if (clearScreen) {
            clearConsole();
        }
        System.out.println("Dealer:");
        System.out.println("=======");
        System.out.println(dealer.getHand().toString(showDealerHoleCard));
        if (showDealerHoleCard) {
            System.out.println("Total:");
            System.out.println(dealer.getHand().getCardTotalString());
        }
        System.out.println("\n\n\n");

        for (Player player : players) {
            System.out.println("Player " + player.getPlayerId());
            System.out.println("========");
            System.out.println(player.getHand());
            System.out.println("Total:");
            System.out.println(player.getHand().getCardTotalString());
        }
    }

    private void clearConsole() {
        // Use ANSI escape codes to clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Shoe getShoe() {
        return shoe;
    }
}
