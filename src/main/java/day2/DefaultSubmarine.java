package day2;

public class DefaultSubmarine implements Submarine {
    private Position position = Position.create(0, 0);

    @Override
    public Position forward(int val) {
        position = position.forward(val);
        return position;
    }

    @Override
    public Position down(int val) {
        position = position.down(val);
        return position;
    }

    @Override
    public Position up(int val) {
        if (position.depth() == 0) {
            return position;
        }

        position = position.up(val);
        return position;
    }

    @Override
    public void executeCommand(Command command) {
        command.execute(this);
    }

    @Override
    public Position position() {
        return position;
    }
}
