package me.kevinmandeville;

import java.util.List;

/**
 * @author kmandeville
 */
public class Game {

    private Dealer dealer;
    private List<Player> players;
    private Shoe shoe;

    public Game(Dealer dealer, List<Player> players, Shoe shoe) {
        this.dealer = dealer;
        this.players = players;
        this.shoe = shoe;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Shoe getShoe() {
        return shoe;
    }
}
