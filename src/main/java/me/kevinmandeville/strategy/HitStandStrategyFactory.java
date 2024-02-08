package me.kevinmandeville.strategy;

import me.kevinmandeville.core.BaseParticipant;
import me.kevinmandeville.core.Dealer;

/**
 * Factory class responsible for creating and distributing specific instances of different playing strategies. One is
 * specific to dealers and rules another strategy is for the player interaction.
 *
 * @author kmandeville
 */
public class HitStandStrategyFactory {

    public HitOrStandStrategy getStrategyInstance(BaseParticipant baseParticipant) {
        if (baseParticipant instanceof Dealer) {
            return new DealerHitOrStandStrategy();
        } else {
            return new PlayerHitOrStandStrategy();
        }
    }
}
