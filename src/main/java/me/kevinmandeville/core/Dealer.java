package me.kevinmandeville.core;

import me.kevinmandeville.strategy.DealerHitOrStandStrategy;
import me.kevinmandeville.strategy.HitOrStandStrategy;

/**
 * @author kmandeville
 */
public class Dealer implements Cardable {

    private HitOrStandStrategy strategy;
    private Hand hand;

    public Dealer() {
        this.hand = new Hand();
        strategy = new DealerHitOrStandStrategy();
    }

    public Dealer(HitOrStandStrategy strategy) {
        this.strategy = strategy;
    }

    public HitOrStandStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void takeCard(Card card) {
        if (this.hand == null) {
            this.hand = new Hand();
        }
        this.hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dealer{");
        sb.append("hand=").append(hand);
        sb.append('}');
        return sb.toString();
    }
}
