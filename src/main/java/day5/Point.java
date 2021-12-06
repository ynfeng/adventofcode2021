package day5;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x,y);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
