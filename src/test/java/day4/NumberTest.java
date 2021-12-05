package day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void should_create_number() {
        Number number = Number.of(1);

        assertThat(number.is(1)).isTrue();
    }

    @Test
    void should_mark() {
        Number number = Number.of(1);

        assertThat(number.isMarked()).isFalse();

        number.mark();
        assertThat(number.isMarked()).isTrue();
    }
}
