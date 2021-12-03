package day3;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void should_get_most_common_bit() {
        Numbers numbers = Numbers.create(
            Lists.newArrayList(
                Number.of("00100"),
                Number.of("11110"),
                Number.of("10110")));

        assertThat(numbers.mostCommonBit(0)).isEqualTo(0);
        assertThat(numbers.mostCommonBit(1)).isEqualTo(1);
        assertThat(numbers.mostCommonBit(2)).isEqualTo(1);
        assertThat(numbers.mostCommonBit(3)).isEqualTo(0);
        assertThat(numbers.mostCommonBit(4)).isEqualTo(1);
    }

    @Test
    void should_get_number_length() {
        Numbers numbers = Numbers.create(
            Lists.newArrayList(
                Number.of("00100"),
                Number.of("11110"),
                Number.of("10110")));

        assertThat(numbers.numberLength()).isEqualTo(5);
    }

    @Test
    void should_0_when_no_numbers() {
        Numbers numbers = Numbers.create(Lists.newArrayList());

        assertThat(numbers.numberLength()).isEqualTo(0);
    }
}
