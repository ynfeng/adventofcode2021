package day5;

import com.google.common.collect.Lists;
import java.util.List;

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

    public static Segment create(String str) {
        String[] items = str.split("->");

        int x1 = Integer.valueOf(items[0].split(",")[0].trim());
        int x2 = Integer.valueOf(items[0].split(",")[1].trim());
        int y1 = Integer.valueOf(items[1].split(",")[0].trim());
        int y2 = Integer.valueOf(items[1].split(",")[1].trim());

        return create(x1, x2, y1, y2);
    }

    public Point[] points() {
        if (isHorizontal()) {
            return getHorizontalPoints();
        }

        if (isVertical()) {
            return getVertiaclPoints();
        }

        if (isDiagonal()) {
            return getDiagonalPoints();
        }

        return new Point[] {};
    }

    private Point[] getDiagonalPoints() {
        List<Point> points = Lists.newArrayList();

        int k = (y2 - y1) / (x2 - x1);
        int x = Math.min(x1, x2);
        int targetY = x == x1 ? y2 : y1;

        while (true) {
            int y = k * (x - x1) + y1;
            points.add(Point.of(x, y));
            x++;
            if (y == targetY) {
                break;
            }
        }

        return points.toArray(new Point[] {});
    }

    public Point[] getVertiaclPoints() {
        int s = Math.min(y1, y2);
        int e = Math.max(y1, y2);

        Point[] points = new Point[e - s + 1];

        int j = 0;
        for (int i = s; i <= e; i++) {
            points[j++] = Point.of(x1, i);
        }

        return points;
    }

    public boolean isVertical() {
        return x1 == x2;
    }

    public boolean isHorizontal() {
        return y1 == y2;
    }

    public boolean isDiagonal() {
        int k = (y2 - y1) / (x2 - x1);

        return k == 1 || k == -1;
    }

    private Point[] getHorizontalPoints() {
        int s = Math.min(x1, x2);
        int e = Math.max(x1, x2);
        Point[] points = new Point[e - s + 1];

        int j = 0;
        for (int i = s; i <= e; i++) {
            points[j++] = Point.of(i, y1);
        }

        return points;
    }

    @Override
    public String toString() {
        return "Segment{" +
            "x1=" + x1 +
            ", y1=" + y1 +
            ", x2=" + x2 +
            ", y2=" + y2 +
            '}';
    }
}
