package me.kevinmandeville.core;

import java.awt.Color;

/**
 * Enum for card suits
 *
 * @author kmandeville
 */
public enum Suit {
    SPADE(Color.BLACK, '\u2660'),
    CLUB(Color.BLACK, '\u2663'),
    DIAMOND(Color.RED, '\u2666'),
    HEART(Color.RED, '\u2764');

    private final Color color;
    private final char symbol;

    Suit(Color color, char symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Suit{");
        sb.append("name=").append(name());
        sb.append(", symbol=").append(symbol);
        sb.append('}');
        return sb.toString();
    }
}
