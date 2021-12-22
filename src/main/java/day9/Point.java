package day9;

import java.util.Optional;

public class Point {
    private final Heightmap heightmap;
    private final int x;
    private final int y;

    public Point(Heightmap heightmap, int x, int y) {
        this.heightmap = heightmap;
        this.x = x;
        this.y = y;
    }

    public static Point create(Heightmap heightmap, int x, int y) {
        return new Point(heightmap, x, y);
    }

    public boolean isLowPoint() {
        int height = heightmap.getHeight(x, y);

        if (height >= getLeftHeight()) {
            return false;
        }

        if (height >= getRightHeight()) {
            return false;
        }

        if (height >= getUpHeight()) {
            return false;
        }

        if (height >= getDownHeight()) {
            return false;
        }

        return true;
    }

    private int getDownHeight() {
        if (y + 1 >= heightmap.height()) {
            return Integer.MAX_VALUE;
        }

        return heightmap.getHeight(x, y + 1);
    }

    private int getUpHeight() {
        if (y == 0) {
            return Integer.MAX_VALUE;
        }

        return heightmap.getHeight(x, y - 1);
    }

    private int getRightHeight() {
        if (x + 1 >= heightmap.width()) {
            return Integer.MAX_VALUE;
        }

        return heightmap.getHeight(x + 1, y);
    }

    private int getLeftHeight() {
        if (x == 0) {
            return Integer.MAX_VALUE;
        }

        return heightmap.getHeight(x - 1, y);
    }

    public int height() {
        return heightmap.getHeight(x, y);
    }

    public int riskLevel() {
        return height() + 1;
    }

    @Override
    public String toString() {
        return "Point{" +
            "height=" + height() +
            ", x=" + x +
            ", y=" + y +
            '}';
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Optional<Point> leftSide() {
        if (x == 0) {
            return Optional.empty();
        }

        Point leftSidePoint = create(heightmap, x - 1, y);

        if (leftSidePoint.height() == 9) {
            return Optional.empty();
        }

        if (leftSidePoint.height() <= height()) {
            return Optional.empty();
        }

        return Optional.of(leftSidePoint);
    }

    public Optional<Point> top() {
        if (y == 0) {
            return Optional.empty();
        }

        Point topPoint = create(heightmap, x, y - 1);

        if (topPoint.height() == 9) {
            return Optional.empty();
        }

        if (topPoint.height() <= height()) {
            return Optional.empty();
        }

        return Optional.of(topPoint);
    }

    public Optional<Point> rightSide() {
        if (x == heightmap.width() - 1) {
            return Optional.empty();
        }

        Point righSidePoint = create(heightmap, x + 1, y);

        if (righSidePoint.height() == 9) {
            return Optional.empty();
        }

        if (righSidePoint.height() <= height()) {
            return Optional.empty();
        }

        return Optional.of(righSidePoint);
    }

    public Optional<Point> bottom() {
        if (y == heightmap.height() - 1) {
            return Optional.empty();
        }

        Point bottomPoint = create(heightmap, x, y + 1);

        if (bottomPoint.height() == 9) {
            return Optional.empty();
        }

        if (bottomPoint.height() <= height()) {
            return Optional.empty();
        }

        return Optional.of(bottomPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
