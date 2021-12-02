package day2;

public abstract class AbstractSubmarine implements Submarine {
    protected Position position = Position.create(0, 0);

    @Override
    public void executeCommand(Command command) {
        command.execute(this);
    }

    @Override
    public Position position() {
        return position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }
}
