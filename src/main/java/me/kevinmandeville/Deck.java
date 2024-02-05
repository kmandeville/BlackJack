package me.kevinmandeville;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author kmandeville
 */
public class Deck {

    private final Queue<Card> cards = new LinkedList<>();

    public Deck(Collection<Card> cards) {
        this.cards.addAll(cards);
    }

    public Deck() {
        brandNewDeck();
    }

    public Deck(Card[] deckArray) {
        this(Arrays.asList(deckArray));
    }

    public void addCardToDeck(Card card) {
        if (this.cards.size() == 52) {
            throw new IllegalStateException("Can't add more cards to a full deck");
        }
        if (this.cards.contains(card)) {
            throw new IllegalArgumentException("Card %s is already in deck".formatted(card));
        }
        this.cards.add(card);
    }

    private void brandNewDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.addCardToDeck(new Card(suit, rank));
            }
        }
    }

    public Card getTopCard() {
        return this.cards.remove();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Deck deck = (Deck) o;
        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        int i = 0;
        for (Card card : cards) {
            sb.append(i++ + ": " + card);
            sb.append("\n\n");
        }
        return sb.toString();
    }
}
