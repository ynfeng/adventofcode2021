package day5;

public class Segment {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Segment(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static Segment create(int x1, int y1, int x2, int y2) {
        return new Segment(x1, y1, x2, y2);
    }

    public boolean isHorizontal() {
        return y1 == y2;
    }

    public boolean isVertical() {
        return x1 == x2;
    }

    public int y() {
        return y1;
    }

    public int startPoint() {
        if (isHorizontal()) {
            return Math.min(x1, x2);
        }

        return Math.min(y1, y2);
    }

    public int endPoint() {
        if (isHorizontal()) {
            return Math.max(x1, x2);
        }

        return Math.max(y1, y2);
    }

    public int x() {
        return x1;
    }
}
