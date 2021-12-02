package day2;

public class DefaultPosition implements Position {
    private final int horizontal;
    private final int depth;

    private DefaultPosition(int horizontal, int depth) {
        this.horizontal = horizontal;
        this.depth = depth;
    }

    public static DefaultPosition create(int horizontal, int depth) {
        return new DefaultPosition(horizontal, depth);
    }

    @Override
    public int horizontal() {
        return horizontal;
    }

    @Override
    public Position forward(int val) {
        return create(horizontal + val, depth);
    }

    @Override
    public int depth() {
        return depth;
    }

    @Override
    public Position down(int val) {
        return create(horizontal, depth + val);
    }

    @Override
    public Position up(int val) {
        return create(horizontal, depth - val);
    }

    @Override
    public int total() {
        return depth() * horizontal();
    }
}
