package day2;

public interface Submarine {
    Position forward(int val);

    Position down(int val);

    Position up(int val);

    void executeCommand(Command command);

    Position position();
}
