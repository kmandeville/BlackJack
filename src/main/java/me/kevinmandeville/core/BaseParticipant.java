package me.kevinmandeville.core;

/**
 * @author kmandeville
 */
public abstract class BaseParticipant implements Cardable {

    protected Hand hand;

    @Override
    public boolean isBusted() {
        return (this.hand.getSoftValue() > 21);
    }

    @Override
    public boolean hasBlackJack() {
        return (this.hand.isBlackJack());
    }

    @Override
    public boolean hasTwentyOne() {
        return (this.hand.size() > 2 && this.hand.getSoftValue() == 21);
    }

    @Override
    public void resetHand() {
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
