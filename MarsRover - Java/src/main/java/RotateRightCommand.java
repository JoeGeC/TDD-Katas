public class RotateRightCommand implements Command {
    MarsRover marsRover;

    RotateRightCommand(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.direction = marsRover.direction.rotateRight();
    }
}
