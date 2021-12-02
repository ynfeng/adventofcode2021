package day2;

public class Submarine {
    private Position position = Position.create(0, 0);

    public Position forward(int val) {
        position = position.forward(val);
        return position;
    }

    public Position down(int val) {
        position = position.down(val);
        return position;
    }

    public Position up(int val) {
        if (position.depth() == 0) {
            return position;
        }

        position = position.up(val);
        return position;
    }

    public void executeCommand(Command command) {
        command.execute(this);
    }

    public Position position() {
        return position;
    }
}
