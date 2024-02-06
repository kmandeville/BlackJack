package me.kevinmandeville.core;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author kmandeville
 */
public class Player implements Cardable {

    private int playerId;
    private String name;
    private BigDecimal bankRoll;
    private Hand hand;

    public Player(int playerId, String name, BigDecimal bankRoll) {
        this.playerId = playerId;
        this.name = name;
        this.bankRoll = bankRoll;
        this.hand = new Hand();
    }

    public Player(int playerId, String name, BigDecimal bankRoll, Hand hand) {
        this.playerId = playerId;
        this.name = name;
        this.bankRoll = bankRoll;
        this.hand = hand;
    }

    public int getPlayerId() {
        return playerId;
    }

    @Override
    public void takeCard(Card card) {
        if (this.hand == null) {
            this.hand = new Hand();
        }
        this.hand.addCard(card);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBankRoll() {
        return bankRoll;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return playerId == player.playerId && Objects.equals(name, player.name) && Objects.equals(
            bankRoll, player.bankRoll) && Objects.equals(hand, player.hand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, name, bankRoll, hand);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("playerId=").append(playerId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", bankRoll=").append(bankRoll);
        sb.append(", hand=").append(hand);
        sb.append('}');
        return sb.toString();
    }
}
