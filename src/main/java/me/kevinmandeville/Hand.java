package me.kevinmandeville;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kmandeville
 */
public class Hand {

    private BigDecimal bet;
    private List<Card> cards;

    public Hand(BigDecimal bet, List<Card> cards) {
        this.bet = bet;
        this.cards = cards;
    }

    public BigDecimal getBet() {
        return bet;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hand{");
        sb.append("bet=").append(bet);
        sb.append(", cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
