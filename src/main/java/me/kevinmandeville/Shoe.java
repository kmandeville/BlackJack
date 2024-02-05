package me.kevinmandeville;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author kmandeville
 */
public class Shoe {

    private Collection<Deck> decks;

    public Shoe() {
        this.decks = new ArrayList<>();
    }

    public Shoe(Shoe shoe) {
        Collection<Deck> newDecks = new ArrayList<>();
        newDecks.addAll(shoe.getDecks());
        this.decks = newDecks;
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    public void addDecks(Collection<Deck> decks) {
        this.decks.addAll(decks);
    }

    public Shoe(Collection<Deck> decks) {
        this.decks = decks;
    }

    public Collection<Deck> getDecks() {
        return decks;
    }
}
