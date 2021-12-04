package day3;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void should_get_number_length() {
        Numbers numbers = Numbers.create(
            Lists.newArrayList(
                Number.of("00100"),
                Number.of("11110"),
                Number.of("10110")));

        assertThat(numbers.eachNumberLength()).isEqualTo(5);
    }

    @Test
    void should_0_when_no_numbers() {
        Numbers numbers = Numbers.create(Lists.newArrayList());

        assertThat(numbers.eachNumberLength()).isEqualTo(0);
    }

    @Test
    void should_get_numbers_count_from_numbers() {
        Numbers numbers = Numbers.create(
            Lists.newArrayList(
                Number.of("00100"),
                Number.of("11110"),
                Number.of("10110")));

        assertThat(numbers.howManyNumbers()).isEqualTo(3);
    }
}
