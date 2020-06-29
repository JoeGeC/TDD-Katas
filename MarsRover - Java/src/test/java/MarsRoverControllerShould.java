import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverControllerShould {

    private MarsRoverController marsRoverController;
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid();
        marsRoverController = new MarsRoverController(grid);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'','0:0:N'",
            "'X','0:0:N'"
    })
    void notMoveGivenInvalidCommand(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'M','0:1:N'",
            "'MM','0:2:N'",
            "'MMMMMMMMMM','0:0:N'",
            "'MMMMMMMMMMMM','0:2:N'"
    })
    void moveNorth(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'RM','1:0:E'",
            "'RMMMMMMMMMM','0:0:E'",
    })
    void moveEast(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'MRRM','0:0:S'",
            "'RRM','0:9:S'",
    })
    void moveSouth(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'RMLLM','0:0:W'",
            "'LM','9:0:W'"
    })
    void moveWest(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'MMRMMLM','2:3:N'"
    })
    void move(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'R','0:0:E'",
            "'RR','0:0:S'",
            "'RRR','0:0:W'",
            "'RRRR','0:0:N'",
    })
    void rotateRight(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'L','0:0:W'",
            "'LL','0:0:S'",
            "'LLL','0:0:E'",
            "'LLLL','0:0:N'",
            "'LLLLL','0:0:W'",
    })
    void rotateLeft(String command, String expectedPosition) {
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'MMMM','O:0:2:N', 0, 3",
            "'RMMMM', 'O:2:0:E', 3, 0",
            "'RRMMMM', 'O:0:0:S', 0, 9",
            "'LMMMM', 'O:0:0:W', 9, 0"
    })
    void moveToTheLastPossiblePointGivenItEncountersObstacle(String command, String expectedPosition, int x, int y) {
        grid.addObstacleAt(x, y);
        assertEquals(expectedPosition, marsRoverController.execute(command));
    }
}
