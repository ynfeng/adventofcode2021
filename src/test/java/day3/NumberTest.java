package day3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void should_get_bit_from_number() {
        Number number = Number.of("10110");

        assertThat(number.bitAt(0)).isEqualTo(0);
        assertThat(number.bitAt(1)).isEqualTo(1);
        assertThat(number.bitAt(2)).isEqualTo(1);
        assertThat(number.bitAt(3)).isEqualTo(0);
        assertThat(number.bitAt(4)).isEqualTo(1);
    }
}
