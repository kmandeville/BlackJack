package me.kevinmandeville.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author kmandeville
 */
public class Hand {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int size() {
        return this.cards.size();
    }

    public int hardValue() {
        int total = 0;
        for (Card card : cards) {
            total += card.getRank().getValue();
        }
        return total;
    }

    public int softValue() {
        int total = 0;
        for (Card card : cards) {
            total += card.getRank().getAlternateValue();
        }
        return total;
    }

    public void addCard(Card card) {
        if (this.cards == null) {
            this.cards = new ArrayList<>();
        }
        this.cards.add(card);
    }

    public boolean isAceShowing() {
        if (this.cards == null || this.cards.isEmpty()) {
            return false;
        }
        if (this.cards.size() == 2 && this.cards.get(1).getRank() == Rank.ACE) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBlackJack() {
        if (this.cards == null || this.cards.isEmpty()) {
            return false;
        }
        if (this.cards.size() == 2 && this.hardValue() == 21) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hand hand = (Hand) o;
        return Objects.equals(cards, hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("  ");
        }
        return sb.toString();
    }

    public String toString(boolean showDealerHoleCard) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);

            // if showDealerHoleCard and on first card - don't show
            if (!showDealerHoleCard && i == 0) {
                sb.append("*** ");
            } else {
                sb.append(card.toString());
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
