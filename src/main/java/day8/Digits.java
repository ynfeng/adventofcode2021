package day8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Digits {
    private final List<Digit> digitList;

    public Digits(String... inputs) {
        digitList = Arrays.stream(inputs)
            .map(Digit::create)
            .collect(Collectors.toList());
    }

    public static Digits create(String... inputs) {
        return new Digits(inputs);
    }

    public int countUniqueNumberOfSegments() {
        return digitList.stream().mapToInt(Digit::countUniqueNumberOfSegments).sum();
    }

    public int sum() {
        return digitList.stream().mapToInt(Digit::number).sum();
    }
}
