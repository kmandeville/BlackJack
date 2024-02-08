package me.kevinmandeville.strategy;

import java.util.Scanner;
import me.kevinmandeville.core.BaseParticipant;

/**
 * @author kmandeville
 */
public interface HitOrStandStrategy {

    void playHand(BaseParticipant baseParticipant, Scanner scanner);
}
