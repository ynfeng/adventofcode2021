package day8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DigitTest {
    @Test
    void should_count_unique_number_of_segments() {
        Digit digit = Digit.create("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");

        assertThat(digit.countUniqueNumberOfSegments()).isEqualTo(2);
    }

}
