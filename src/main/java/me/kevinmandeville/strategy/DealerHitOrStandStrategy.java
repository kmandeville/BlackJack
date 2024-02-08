package me.kevinmandeville.strategy;

import java.util.Scanner;
import me.kevinmandeville.Game;
import me.kevinmandeville.core.BaseParticipant;
import me.kevinmandeville.core.Dealer;
import me.kevinmandeville.core.Hand;

/**
 * Dealer strategy of when the dealer should take a hit and when they should stand. This strategy has the dealer always
 * hitting on a soft 17 as well as a total of 16 or less.
 *
 * @author kmandeville
 */
public class DealerHitOrStandStrategy extends AbstractHitStandStrategy {

    public DealerHitOrStandStrategy() {
        super();
    }

    public DealerHitOrStandStrategy(Game game) {
        super(game);
    }

    public boolean shouldHit(Hand hand) {
        return hand.getHardValue() <= 16 && hand.getSoftValue() <= 17;
    }

    public boolean shouldStand(Hand hand) {
        return hand.getHardValue() >= 17 && hand.getSoftValue() <= 18;
    }

    @Override
    public void playHand(BaseParticipant baseParticipant, Scanner scanner) {
        Dealer dealer = (Dealer) baseParticipant;

        // Have to make dealers hole card visible and show the dealer total
        getGame().printGame(true, true);
        while (dealer.getHand().getSoftValue() <= 17) {
            // deal card for hit, if under 21, loop again
            dealer.takeCard(getGame().getShoe().getNextCard());
            getGame().printGame(true, true);
            if (dealer.isBusted()) {
                System.out.println("Dealer Busted! Game Over.");
                break;
            }
            if (dealer.hasTwentyOne()) {
                System.out.println("Dealer has 21! End turn.");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
