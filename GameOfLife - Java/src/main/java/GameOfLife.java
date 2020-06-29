public class GameOfLife {
    private static final char ALIVE = '*';
    private static final char DEAD = '.';
    private char[][] currentGrid;

    public void seedGrid(String grid) {
        String[] rows = grid.split("\n");
        currentGrid = new char[rows.length][];
        for (int gridRow = 0; gridRow < rows.length; gridRow++) {
            currentGrid[gridRow] = rows[gridRow].toCharArray();
        }
    }

    public void getNextGeneration() {
        StringBuilder nextGenerationRow = new StringBuilder();

        for(int row = 0; row < currentGrid.length; row++) {
            for (int column = 0; column < currentGrid[row].length; column++) {
                if (cellNotBeginningOrEnd(row, column) && previousCellIsAlive(row, column) && nextCellIsAlive(row, column)) {
                    nextGenerationRow.append(ALIVE);
                } else {
                    nextGenerationRow.append(DEAD);
                }
            }
            currentGrid[row] = nextGenerationRow.toString().toCharArray();
            nextGenerationRow = new StringBuilder();
        }
    }

    public String printCurrentGrid() {
        StringBuilder currentGeneration = new StringBuilder();
        for(int row = 0; row < currentGrid.length; row++) {
            currentGeneration.append(new String(currentGrid[row]));
            if (row < currentGrid.length - 1){
                currentGeneration.append("\n");
            }
        }
        return currentGeneration.toString();
    }

    private boolean cellNotBeginningOrEnd(int cellRow, int cellColumn) {
        return cellColumn != 0 && cellColumn != currentGrid[cellRow].length- 1;
    }

    private boolean previousCellIsAlive(int cellRow, int cellColumn) {
        char previousCell = currentGrid[cellRow][cellColumn - 1];
        return cellIsAliveAt(previousCell);
    }

    private boolean nextCellIsAlive(int cellRow, int cellColumn) {
        char nextCell = currentGrid[cellRow][cellColumn + 1];
        return cellIsAliveAt(nextCell);
    }

    private static boolean cellIsAliveAt(char cell) {
        return cell == ALIVE;
    }
}
