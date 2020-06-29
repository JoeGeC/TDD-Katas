import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingAcceptanceTest {
    @Test
    void acceptanceTest1() {
        assertEquals(300, new Bowling("X X X X X X X X X X X X").totalScore());
        assertEquals(90, new Bowling("9-9-9-9-9-9-9-9-9-9-").totalScore());
        assertEquals(150, new Bowling("5/5/5/5/5/5/5/5/5/5/5").totalScore());
    }
}
