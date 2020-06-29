import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingShould {
    @Test
    void returnZero_GivenEmptyString() { assertScore("", 0); }

    @Test
    void returnOne_GivenOne() { assertScore("1", 1); }

    @Test
    void returnTwo_GivenTwo() { assertScore("2", 2); }

    @Test
    void returnZero_GivenMiss() { assertScore("-", 0); }

    @Test
    void returnZero_GivenTwoMisses() { assertScore("--", 0); }

    @Test
    void returnTwo_GivenTwoOnes() { assertScore("11", 2); }

    @Test
    void returnTenPlusNextRoll_GivenSpare() { assertScore("6/11", 13); }

    @Test
    void returnTenPlusNextTwoRolls_GivenStrike() { assertScore("X 11", 14); }

    @Test
    void handleTwoStrikes() { assertScore("X X 11", 35); }

    @Test
    void handleThreeStrikes() { assertScore("X X X 11", 65); }

    @Test
    void handleEndGameStrike() { assertScore("111111111111111111X X X", 48); }

    @Test
    void handleEndGameSpare() { assertScore("1111111111111111115/X", 38); }

    void assertScore(String rolls, int expected){
        assertEquals(expected, new Bowling(rolls).totalScore());
    }
}
