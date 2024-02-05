package me.kevinmandeville;

import java.util.Objects;

/**
 * @author kmandeville
 */
public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(rank.getCharacterRepresentation()).append(" (").append(suit.getSymbol()).append(") ");
        return sb.toString();
    }
}
