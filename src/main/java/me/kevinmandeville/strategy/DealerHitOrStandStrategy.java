package me.kevinmandeville.strategy;

import me.kevinmandeville.core.Hand;

/**
 * Dealer strategy of when the dealer should take a hit and when they should stand. Since Dealers do not Split or
 * Doubledown, those methods return false. This strategy has the dealer always hitting on a soft 17 as well as a total
 * of 16 or less.
 *
 * @author kmandeville
 */
public class DealerHitOrStandStrategy implements HitOrStandStrategy {

    @Override
    public boolean shouldHit(Hand hand) {
        return hand.hardValue() <= 16 && hand.softValue() <= 17;
    }

    @Override
    public boolean shouldStand(Hand hand) {
        return hand.hardValue() >= 17 && hand.softValue() <= 18;
    }

    @Override
    public boolean shouldSplit(Hand hand) {
        return false;
    }

    @Override
    public boolean shouldDoubleDown(Hand hand) {
        return false;
    }
}
