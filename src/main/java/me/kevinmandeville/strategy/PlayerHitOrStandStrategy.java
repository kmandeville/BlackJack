package me.kevinmandeville.strategy;

import java.util.Scanner;
import me.kevinmandeville.Game;
import me.kevinmandeville.core.BaseParticipant;
import me.kevinmandeville.core.Player;

/**
 * Class that encapsulates the flow for the player hand process, requesting whether to hit or stand, loop, checking for
 * busting, 21, etc.
 *
 * @author kmandeville
 */
public class PlayerHitOrStandStrategy extends AbstractHitStandStrategy {

    public PlayerHitOrStandStrategy() {
        super();
    }

    public PlayerHitOrStandStrategy(Game game) {
        super(game);
    }

    @Override
    public void playHand(BaseParticipant baseParticipant, Scanner scanner) {
        Player player = (Player) baseParticipant;
        String hitOrStand;
        do {
            System.out.println();
            System.out.printf("Player %d: Hit (H) or Stand (S)?%n", player.getPlayerId());
            
            hitOrStand = scanner.next();
            //      deal card for hit, if under 21, loop again
            if (hitOrStand.equalsIgnoreCase("H")) {
                player.takeCard(getGame().getShoe().getNextCard());
                getGame().printGame(true, false);
                if (player.isBusted()) {
                    System.out.println("BUSTED! Game Over.");
                    break;
                }
                if (player.hasTwentyOne()) {
                    System.out.println("Player has 21! End turn.");
                    break;
                }
            }
        } while (hitOrStand.equalsIgnoreCase("H"));
    }
}
