public class RotateLeftCommand implements Command {
    MarsRover marsRover;

    RotateLeftCommand(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.direction = marsRover.direction.rotateLeft();
    }
}
