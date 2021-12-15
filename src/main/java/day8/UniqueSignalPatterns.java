package day8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueSignalPatterns {
    private final List<UniqueSignalPattern> patters;

    private UniqueSignalPatterns(String input) {
        patters = Arrays.stream(input.split(" "))
            .map(UniqueSignalPattern::create)
            .collect(Collectors.toList());
    }

    public static UniqueSignalPatterns create(String input) {
        return new UniqueSignalPatterns(input);
    }

    public List<UniqueSignalPattern> getByLength(int length) {
        return patters.stream()
            .filter(it -> it.length() == length)
            .collect(Collectors.toList());
    }
}
