package me.kevinmandeville.strategy;

import me.kevinmandeville.Game;

/**
 * @author kmandeville
 */
public abstract class AbstractHitStandStrategy implements HitOrStandStrategy {

    private final Game game;

    protected AbstractHitStandStrategy() {
        this.game = Game.getInstance();
    }

    protected AbstractHitStandStrategy(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
