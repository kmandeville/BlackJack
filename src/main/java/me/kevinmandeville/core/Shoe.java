package me.kevinmandeville.core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kmandeville
 */
public class Shoe {

    private Queue<Deck> decks;

    public Shoe() {
        this.decks = new LinkedList<>();
    }

    public void init(int numberOfDecks) {
        for (int i = 0; i < numberOfDecks; i++) {
            this.decks.add(new Deck());
        }
    }

    public Shoe(Shoe shoe) {
        this.decks = new LinkedList<>(shoe.getDecks());
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    public void addDecks(Collection<Deck> decks) {
        this.decks.addAll(decks);
    }

    public Card getNextCard() {
        if (decks.isEmpty()) {
            throw new IllegalStateException("Shoe is empty. Set up new shoe with new shuffled decks");
        }

        Deck deck = decks.remove();
        Card topCard = deck.getTopCard();

        return topCard;
    }

    public int size() {
        if (decks.isEmpty()) {
            return 0;
        }

        int size = 0;
        for (Deck deck : decks) {
            size += deck.size();
        }
        return size;
    }

    public Shoe(Queue<Deck> decks) {
        this.decks = decks;
    }

    public Queue<Deck> getDecks() {
        return decks;
    }
}
