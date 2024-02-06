package me.kevinmandeville.core;

/**
 * @author kmandeville
 */
public enum Rank {
    ACE(11, 1, "A"),
    TWO(2, 2, "2"),
    THREE(3, 3, "3"),
    FOUR(4, 4, "4"),
    FIVE(5, 4, "5"),
    SIX(6, 6, "6"),
    SEVEN(7, 7, "7"),
    EIGHT(8, 8, "8"),
    NINE(9, 9, "9"),
    TEN(10, 10, "10"),
    JACK(10, 10, "J"),
    QUEEN(10, 10, "Q"),
    KING(10, 10, "K");

    private final int value;
    private final int alternateValue;
    private final String characterRepresentation;

    Rank(int value, int alternateValue, String characterRepresentation) {
        this.value = value;
        this.alternateValue = alternateValue;
        this.characterRepresentation = characterRepresentation;
    }

    public int getValue() {
        return value;
    }

    public int getAlternateValue() {
        return alternateValue;
    }

    public String getCharacterRepresentation() {
        return characterRepresentation;
    }
}
