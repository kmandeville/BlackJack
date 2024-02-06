package me.kevinmandeville.strategy;

import me.kevinmandeville.core.Hand;

/**
 * @author kmandeville
 */
public interface HitOrStandStrategy {

    boolean shouldHit(Hand hand);

    boolean shouldStand(Hand hand);

    boolean shouldSplit(Hand hand);

    boolean shouldDoubleDown(Hand hand);
}
