package day9;

import java.util.Comparator;
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

        List<Basin> threeLargestBasin = lowPoints.stream()
            .map(Basin::create)
            .sorted(Comparator.comparingInt(Basin::area).reversed())
            .limit(3)
            .collect(Collectors.toList());

        return threeLargestBasin.stream().mapToInt(Basin::area).reduce((a, b) -> a * b).getAsInt();
    }
}
