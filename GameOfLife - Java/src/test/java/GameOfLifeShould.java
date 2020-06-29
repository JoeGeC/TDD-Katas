import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeShould {
    private GameOfLife gameOfLife;

    @Before
    public void setup() {
        gameOfLife = new GameOfLife();
    }

    @Test
    public void returnAnEmptyGridGivenEmptyGrid() {
        gameOfLife.seedGrid("");
        assertGetNextGeneration("");
    }

    @Test
    public void returnDeadCellGivenDeadCell() {
        gameOfLife.seedGrid(".");
        assertGetNextGeneration(".");
    }

    @Test
    public void returnDeadCellGivenAliveCell() {
        gameOfLife.seedGrid("*");
        assertGetNextGeneration(".");
    }

    @Test
    public void returnTwoDeadCellsGivenTwoAliveCells() {
        gameOfLife.seedGrid("**");
        assertGetNextGeneration("..");
    }

    @Test
    public void returnOneAliveCellGivenThreeAliveCells() {
        gameOfLife.seedGrid("***");
        assertGetNextGeneration(".*.");
    }

    @Test
    public void returnTwoAliveCellGivenFourAliveCells() {
        gameOfLife.seedGrid("****");
        assertGetNextGeneration(".**.");
    }

    @Test
    public void returnFourDeadCells_GivenFourAliveCells_AfterTwoGenerations() {
        gameOfLife.seedGrid("****");
        assertGetNextGeneration(".**.");
        assertGetNextGeneration("....");
    }

    @Test
    public void returnTwoDeadRows_GivenTwoDeadRows() {
        gameOfLife.seedGrid(".\n.");
        assertGetNextGeneration(".\n.");
    }

    private void assertGetNextGeneration(String expected) {
        gameOfLife.getNextGeneration();
        assertEquals(expected, gameOfLife.printCurrentGrid());
    }
}
