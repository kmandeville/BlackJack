package me.kevinmandeville.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import me.kevinmandeville.Shuffler;

/**
 * @author kmandeville
 */
public class Shoe {

    private Queue<Card> cards;

    public Shoe() {
        this.cards = new LinkedList<>();
    }

    public Shoe(Card[] shuffledArray) {
        this();
        this.cards = new LinkedList<>();
        this.cards.addAll(List.of(shuffledArray));
    }

    public void init(int numberOfDecks) {
        for (int i = 0; i < numberOfDecks; i++) {
            Deck newDeck = Shuffler.shuffleDeck(new Deck(), 4);
            this.cards.addAll(newDeck.getCards());
        }
    }

    public Shoe(Shoe shoe) {
        this.cards = new LinkedList<>(shoe.getCards());
    }

    public Card getNextCard() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("Shoe is empty. Set up new shoe new cards");
        }

        return this.cards.remove();
    }

    public int size() {
        if (cards.isEmpty()) {
            return 0;
        }

        return this.cards.size();
    }


    public Queue<Card> getCards() {
        return new LinkedList<>(cards);
    }
}
