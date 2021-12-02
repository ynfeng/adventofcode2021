package day2;

public interface Position {
    int horizontal();

    int depth();

    Position forward(int val);

    Position down(int val);

    Position up(int val);

    int total();
}
