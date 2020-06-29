import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridShould {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid();
    }

    @Test
    void be2dArray() {
        assertEquals(100, grid.plateau[0].length * grid.plateau[1].length);
    }

    @Test
    void beCreatedWithEmptyCells() {
        for (int x = 0; x < Grid.WIDTH; x++) {
            for (int y = 0; y < Grid.HEIGHT; y++) {
                assertEquals(Character.MIN_VALUE, grid.plateau[x][y]);
            }
        }
    }

    @Test
    void containAnObstacle() {
        grid.addObstacleAt(0, 0);
        assertTrue(grid.isObstacleAt(0, 0));
    }
}
