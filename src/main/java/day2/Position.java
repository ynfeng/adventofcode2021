package day2;

public class Position {
    private final int horizontal;
    private final int depth;

    private Position(int horizontal, int depth) {
        this.horizontal = horizontal;
        this.depth = depth;
    }

    public static Position create(int horizontal, int depth) {
        return new Position(horizontal, depth);
    }

    public int horizontal() {
        return horizontal;
    }

    public Position forward(int val) {
        return create(horizontal + val, depth);
    }

    public int depth() {
        return depth;
    }

    public Position down(int val) {
        return create(horizontal, depth + val);
    }

    public Position up(int val) {
        return create(horizontal, depth - val);
    }
}
