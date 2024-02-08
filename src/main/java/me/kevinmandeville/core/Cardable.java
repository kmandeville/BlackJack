package me.kevinmandeville.core;

/**
 * @author kmandeville
 */
public interface Cardable {

    void takeCard(Card card);

    boolean isBusted();

    void resetHand();

    boolean hasBlackJack();

    boolean hasTwentyOne();
}
