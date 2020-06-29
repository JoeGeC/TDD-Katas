import java.util.ArrayList;
import java.util.List;

public class MarsRoverController {
    private static final String MOVE = "M";
    private static final String ROTATE_RIGHT = "R";
    private static final String ROTATE_LEFT = "L";
    private final MarsRover marsRover;


    private MoveCommand moveCommand;
    private RotateRightCommand rotateRightCommand;
    private RotateLeftCommand rotateLeftCommand;
    private List<Command> commands;

    public MarsRoverController(Grid grid) {
        marsRover = new MarsRover(grid);
        moveCommand = new MoveCommand(marsRover);
        rotateRightCommand = new RotateRightCommand(marsRover);
        rotateLeftCommand = new RotateLeftCommand(marsRover);
        commands = new ArrayList<>();
    }

    public String execute(String input) {
        if (input.isEmpty()) {
            return marsRover.formatPosition();
        }

        setCommands(input);

        for(Command command : commands) {
            command.execute();
        }
        return marsRover.formatPosition();
    }

    private void setCommands(String input) {
        String[] inputCommands = input.split("");
        for (String command : inputCommands) {
            if (isMoveCommand(command)) {
                commands.add(moveCommand);
            } else if (isRotateRightCommand(command)) {
                commands.add(rotateRightCommand);
            } else if (isRotateLeftCommand(command)) {
                commands.add(rotateLeftCommand);
            }
        }
    }

    private boolean isMoveCommand(String command) {
        return command.equals(MOVE);
    }

    private boolean isRotateLeftCommand(String command) {
        return command.equals(ROTATE_LEFT);
    }

    private boolean isRotateRightCommand(String command) {
        return command.equals(ROTATE_RIGHT);
    }
}
