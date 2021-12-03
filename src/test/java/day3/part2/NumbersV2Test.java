package day3.part2;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import day3.Number;
import day3.NumbersTestSupport;
import org.junit.jupiter.api.Test;

class NumbersV2Test extends NumbersTestSupport {

    @Test
    void should_filter_numbers_by_bit() {
        NumbersV2 numbers = NumbersV2.create(getNumberList());

        numbers = numbers.filter(it -> it.bitAt(4) == 1);

        assertThat(numbers).isEqualTo(NumbersV2.create(Lists.newArrayList(
            Number.of("11110"),
            Number.of("10110"),
            Number.of("10111"),
            Number.of("10101"),
            Number.of("11100"),
            Number.of("10000"),
            Number.of("11001"))));
    }
}
