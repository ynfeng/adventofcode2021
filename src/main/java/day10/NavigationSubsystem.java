package day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NavigationSubsystem {
    private final List<Chunks> chunksList;

    public NavigationSubsystem(String[] lines) {
        chunksList = Arrays.stream(lines).map(Chunks::create).collect(Collectors.toList());
    }

    public static NavigationSubsystem of(String... lines) {
        return new NavigationSubsystem(lines);
    }

    public int points() {
        return chunksList.stream().mapToInt(it -> it.missed().points()).sum();
    }
}
