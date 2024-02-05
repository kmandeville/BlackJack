package me.kevinmandeville;

import java.util.Random;

/**
 * @author kmandeville
 */
public class Shuffler {

    public Deck shuffleDeck(Deck deck) {
        // go through deck one at a time and create a new queue of cards to create a new Deck
        Card[] shuffledArray = new Card[52];

        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            Card card = deck.getTopCard();
            // find random slot for card in array
            int arrayPos = 0;
            while (shuffledArray[arrayPos] != null) {
                arrayPos = random.nextInt(52);
            }
            shuffledArray[arrayPos] = card;
        }

        return new Deck(shuffledArray);
    }

    /**
     * Shuffle a deck a certain number of times defined by passed in iterations
     *
     * @param deck       Deck to shuffle
     * @param iterations number of times to shuffle the deck
     * @return Deck that has been shuffled
     */
    public Deck shuffleDeck(Deck deck, int iterations) {
        Deck shuffledDeck = deck;
        for (int i = 0; i < iterations; i++) {
            shuffledDeck = shuffleDeck(shuffledDeck);
        }
        return shuffledDeck;
    }

    public Shoe shuffleShoe(Shoe shoe) {
        Shoe shuffledShoe = new Shoe();

        for (Deck deck : shoe.getDecks()) {
            shuffledShoe.addDeck(this.shuffleDeck(deck));
        }

        return shuffledShoe;
    }

    public Shoe shuffleShoe(Shoe shoe, int iterations) {
        Shoe shuffledShoe = new Shoe(shoe);

        for (int i = 0; i < iterations; i++) {
            shuffledShoe = this.shuffleShoe(shuffledShoe);
        }

        return shuffledShoe;
    }
}
