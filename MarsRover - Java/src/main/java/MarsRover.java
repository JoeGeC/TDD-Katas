class MarsRover {
    private String obstacleFound = "";
    private int positionX = 0;
    private int positionY = 0;
    Direction direction = Direction.NORTH;
    private Grid grid;

    MarsRover(Grid grid) {
        this.grid = grid;
    }

    String formatPosition() {
        return obstacleFound + positionX + ":" + positionY + ":" + direction;
    }

    void moveNorth() {
        positionY++;
        if (positionY >= Grid.HEIGHT) {
            positionY = 0;
        }
        if (grid.isObstacleAt(positionX, positionY)) {
            moveSouth();
            obstacleFound = "O:";
        }
    }

    void moveSouth() {
        positionY--;
        if (positionY < 0) {
            positionY = Grid.HEIGHT - 1;
        }
        if (grid.isObstacleAt(positionX, positionY)) {
            moveNorth();
            obstacleFound = "O:";
        }
    }

    void moveEast() {
        positionX++;
        if (positionX >= Grid.WIDTH) {
            positionX = 0;
        }
        if (grid.isObstacleAt(positionX, positionY)) {
            moveWest();
            obstacleFound = "O:";
        }
    }

    void moveWest() {
        positionX--;
        if (positionX < 0) {
            positionX = Grid.WIDTH - 1;
        }
        if (grid.isObstacleAt(positionX, positionY)) {
            moveEast();
            obstacleFound = "O:";
        }
    }

    boolean directionIsNorth() {
        return direction == Direction.NORTH;
    }

    boolean directionIsSouth() {
        return direction == Direction.SOUTH;
    }

    boolean directionIsEast() {
        return direction == Direction.EAST;
    }
}
