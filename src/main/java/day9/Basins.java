package day9;

import java.util.List;
import java.util.stream.Collectors;

public class Basins {
    private final Heightmap heightmap;

    public Basins(Heightmap heightmap) {
        this.heightmap = heightmap;
    }

    public static Basins create(Heightmap heightmap) {
        return new Basins(heightmap);
    }

    public int risk() {
        List<Point> lowPoints = heightmap.lowPoints();

        List<Integer> threeLargestBasinsSize = lowPoints.stream()
            .map(Basin::create)
            .map(Basin::area)
            .sorted((a, b) -> b - a)
            .limit(3)
            .collect(Collectors.toList());

        return threeLargestBasinsSize.stream().reduce((a, b) -> a * b).get();
    }
}
