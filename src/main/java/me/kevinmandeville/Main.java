package me.kevinmandeville;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println("In order:");
        System.out.println(deck);

        Shuffler shuffler = new Shuffler();
        Deck shuffledDeck = shuffler.shuffleDeck(deck);

        System.out.println("Shuffled: ");
        System.out.println(shuffledDeck);
    }
}