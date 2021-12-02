package day2.part2;

import day2.DefaultPosition;
import day2.Position;

public class RotatablePosition implements Position {
    private final DefaultPosition defaultPosition;
    private final int aim;

    private RotatablePosition(int horizontal, int depth, int aim) {
        defaultPosition = DefaultPosition.create(horizontal, depth);
        this.aim = aim;
    }

    public static RotatablePosition create(int horizontal, int depth, int aim) {
        return new RotatablePosition(horizontal, depth, aim);
    }

    @Override
    public int horizontal() {
        return defaultPosition.horizontal();
    }

    @Override
    public Position forward(int val) {
        return create(horizontal() + val, depth() + aim * val, aim);
    }

    @Override
    public int depth() {
        return defaultPosition.depth();
    }

    @Override
    public Position down(int val) {
        return create(horizontal(), depth(), aim + val);
    }

    @Override
    public Position up(int val) {
        return create(horizontal(), depth(), aim - val);
    }

    @Override
    public int total() {
        return depth() * horizontal();
    }

    public int aim() {
        return aim;
    }
}
