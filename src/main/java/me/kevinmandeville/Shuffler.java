package me.kevinmandeville;

import static me.kevinmandeville.Game.NUMBER_OF_DECKS_FOR_SHOE;

import java.util.Random;
import me.kevinmandeville.core.Card;
import me.kevinmandeville.core.Deck;
import me.kevinmandeville.core.Shoe;

/**
 * @author kmandeville
 */
public class Shuffler {

    public static final int NUMBER_OF_CARDS_IN_SHOE = 52 * NUMBER_OF_DECKS_FOR_SHOE;
    private static final Random random = new Random();

    private Shuffler() {
    }

    public static Deck shuffleDeck(Deck deck) {
        // go through deck one at a time and create a new queue of cards to create a new Deck
        Card[] shuffledArray = new Card[52];

        for (int i = 0; i < 52; i++) {
            Card card = deck.getTopCard();
            // find random slot for card in array
            int arrayPos;

            do {
                arrayPos = random.nextInt(52);
            } while (shuffledArray[arrayPos] != null);

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
    public static Deck shuffleDeck(Deck deck, int iterations) {
        Deck shuffledDeck = deck;
        for (int i = 0; i < iterations; i++) {
            shuffledDeck = shuffleDeck(shuffledDeck);
        }
        return shuffledDeck;
    }

    public static Shoe shuffleShoe(Shoe shoe) {
        Card[] shuffledArray = new Card[NUMBER_OF_CARDS_IN_SHOE];

        for (int i = 0; i < NUMBER_OF_CARDS_IN_SHOE; i++) {
            Card card = shoe.getNextCard();
            // find random slot for card in array
            int arrayPos;

            do {
                arrayPos = random.nextInt(NUMBER_OF_CARDS_IN_SHOE);
            } while (shuffledArray[arrayPos] != null);

            shuffledArray[arrayPos] = card;
        }

        return new Shoe(shuffledArray);
    }

    public static Shoe shuffleShoe(Shoe shoe, int iterations) {
        Shoe shuffledShoe = new Shoe(shoe);

        for (int i = 0; i < iterations; i++) {
            shuffledShoe = shuffleShoe(shuffledShoe);
        }

        return shuffledShoe;
    }
}
