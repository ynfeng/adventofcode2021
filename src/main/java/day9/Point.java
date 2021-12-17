package day9;

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
}
