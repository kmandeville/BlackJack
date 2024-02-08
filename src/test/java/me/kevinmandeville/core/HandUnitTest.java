package me.kevinmandeville.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author kmandeville
 */
public class HandUnitTest {

    @Test
    void testHardValue() {
        Hand hand = new Hand(List.of(new Card(Suit.CLUB, Rank.EIGHT), new Card(Suit.DIAMOND, Rank.JACK)));
        assertThat(hand.getHardValue()).isEqualTo(18);

        hand = new Hand(List.of(new Card(Suit.CLUB, Rank.ACE), new Card(Suit.DIAMOND, Rank.JACK)));
        assertThat(hand.getHardValue()).isEqualTo(21);

        hand = new Hand(List.of(new Card(Suit.CLUB, Rank.TWO),
            new Card(Suit.DIAMOND, Rank.JACK),
            new Card(Suit.CLUB, Rank.THREE),
            new Card(Suit.CLUB, Rank.FOUR)));
        assertThat(hand.getHardValue()).isEqualTo(19);
    }

    @Test
    void testSoftValue() {
        Hand hand = new Hand(List.of(new Card(Suit.CLUB, Rank.EIGHT), new Card(Suit.DIAMOND, Rank.JACK)));
        assertThat(hand.getSoftValue()).isEqualTo(18);

        hand = new Hand(List.of(new Card(Suit.CLUB, Rank.ACE), new Card(Suit.DIAMOND, Rank.JACK)));
        assertThat(hand.getSoftValue()).isEqualTo(11);
    }
}
