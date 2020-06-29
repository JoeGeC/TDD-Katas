public class Grid {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final char OBSTACLE = 'O';
    public char[][] plateau = new char[WIDTH][HEIGHT];

    public void addObstacleAt(int x, int y) {
        plateau[x][y] = OBSTACLE;
    }

    public boolean isObstacleAt(int x, int y) {
        return plateau[x][y] == OBSTACLE;
    }
}
