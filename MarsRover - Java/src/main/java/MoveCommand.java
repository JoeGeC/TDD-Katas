public class MoveCommand implements Command {
    private MarsRover marsRover;

    MoveCommand(MarsRover marsRover) {

        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        moveInDirection();
    }

    private void moveInDirection() {
        if (marsRover.directionIsNorth()) {
            marsRover.moveNorth();
        } else if (marsRover.directionIsSouth()) {
            marsRover.moveSouth();
        } else if (marsRover.directionIsEast()) {
            marsRover.moveEast();
        } else {
            marsRover.moveWest();
        }
    }
}