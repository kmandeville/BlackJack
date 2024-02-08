package me.kevinmandeville.core;

/**
 * @author kmandeville
 */
public class Dealer extends BaseParticipant implements Cardable {

    public Dealer() {
        super.hand = new Hand();
    }

    @Override
    public void takeCard(Card card) {
        if (super.hand == null) {
            super.hand = new Hand();
        }
        super.hand.addCard(card);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dealer{");
        sb.append("hand=").append(hand);
        sb.append('}');
        return sb.toString();
    }
}
