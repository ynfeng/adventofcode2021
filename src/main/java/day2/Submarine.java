package day2;

public interface Submarine {
    Submarine forward(int val);

    Submarine down(int val);

    Submarine up(int val);

    int horizontal();

    int depth();

    int positionResult();

    void executeCommand(Command command);
}
