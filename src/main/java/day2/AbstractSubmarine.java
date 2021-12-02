package day2;

public abstract class AbstractSubmarine implements Submarine {
    private Position position ;

    protected AbstractSubmarine(Position position) {
        this.position = position;
    }

    @Override
    public void executeCommand(Command command) {
        command.execute(this);
    }

    protected Position position() {
        return position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int horizontal() {
        return position.horizontal();
    }

    @Override
    public int depth() {
        return position.depth();
    }

    @Override
    public int positionTotal() {
        return position.total();
    }
}
