package day2;

import java.util.List;
import java.util.stream.Collectors;

public class Command {

    private final Direction direction;
    private final int distance;

    public Command(Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public static Command create(String commandDescription) {
        String[] cmdDescs = commandDescription.split(" ");

        String dir = cmdDescs[0];
        String dis = cmdDescs[1];

        Direction direction = Direction.formString(dir);
        int distance = Integer.valueOf(dis);
        return new Command(direction, distance);
    }

    public static Command[] create(List<String> commandDescriptions) {
        return commandDescriptions.stream()
            .map(Command::create)
            .collect(Collectors.toList())
            .toArray(new Command[] {});
    }

    public Direction direction() {
        return direction;
    }

    public int distance() {
        return distance;
    }

    public void execute(Submarine submarine) {
        direction.execute(submarine, distance);
    }
}
