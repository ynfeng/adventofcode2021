package day10;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class NavigationSubsystem {
    private final List<Chunks> chunksList;

    public NavigationSubsystem(String[] lines) {
        chunksList = Arrays.stream(lines).map(Chunks::create).collect(toList());
    }

    public static NavigationSubsystem of(String... lines) {
        return new NavigationSubsystem(lines);
    }

    public int corruptPoints() {
        return chunksList.stream().mapToInt(it -> it.missed().corruptedPoints()).sum();
    }

    public long completePoints() {
        long[] points = chunksList.stream()
            .filter(chunks -> chunks.isIncomplete())
            .mapToLong(chunks -> chunks.completePoints())
            .sorted()
            .toArray();

        return points[points.length / 2];
    }
}
