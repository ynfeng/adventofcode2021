package day3.part2;

import day3.Number;
import day3.Numbers;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumbersV2 extends Numbers {
    private NumbersV2(List<Number> numberList) {
        super(numberList);
    }

    public static NumbersV2 create(List<Number> numberList) {
        return new NumbersV2(numberList);
    }

    public NumbersV2 filter(Predicate<Number> predicate) {
        List<Number> result = numberList().stream().filter(predicate).collect(Collectors.toList());

        return create(result);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public NumbersV2 copy() {
        return filter(it -> true);
    }
}
