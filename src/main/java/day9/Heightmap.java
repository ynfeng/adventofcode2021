package day9;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;

public class Heightmap {
    private final int[][] heightmapDatas;
    private final List<Point> points = Lists.newArrayList();

    private Heightmap(int[][] heightmapDatas) {
        this.heightmapDatas = heightmapDatas;

        for (int i = 0; i < heightmapDatas.length; i++) {
            for (int j = 0; j < heightmapDatas[i].length; j++) {
                points.add(Point.create(this, j, i));
            }
        }
    }

    public static Heightmap create(int[][] heightMap) {
        return new Heightmap(heightMap);
    }

    public int countLowPoints() {
        return lowPoints().size();
    }

    public List<Point> lowPoints() {
        return points.stream().filter(Point::isLowPoint).collect(Collectors.toList());
    }

    public int getHeight(int x, int y) {
        return heightmapDatas[y][x];
    }

    public int width() {
        return heightmapDatas[0].length;
    }

    public int height() {
        return heightmapDatas.length;
    }

    public int riskLevelsSum() {
        return lowPoints()
            .stream()
            .mapToInt(Point::riskLevel)
            .sum();
    }
}
