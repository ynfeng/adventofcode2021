package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SegmentTest {
    @Test
    void should_create_segment() {
        Segment segment = Segment.create(0, 0, 0, 2);

        assertThat(segment).isNotNull();
    }
}
