package day3;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class NumbersTestSupport {
    protected static Numbers getTestNumbers() {
        return Numbers.create(getNumberList());
    }

    protected static ArrayList<Number> getNumberList() {
        return Lists.newArrayList(
            Number.of("00100"),
            Number.of("11110"),
            Number.of("10110"),
            Number.of("10111"),
            Number.of("10101"),
            Number.of("01111"),
            Number.of("00111"),
            Number.of("11100"),
            Number.of("10000"),
            Number.of("11001"),
            Number.of("00010"),
            Number.of("01010"));
    }
}
