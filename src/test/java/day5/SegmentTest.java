package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SegmentTest {

    @Test
    void should_detect_if_is_a_horizontal_segment() {
        assertThat(Segment.create(3, 7, 10, 7).isHorizontal()).isTrue();
        assertThat(Segment.create(4, 8, 4, 7).isHorizontal()).isFalse();
    }

    @Test
    void should_detect_if_is_a_vertical_segment() {
        assertThat(Segment.create(3, 7, 3, 11).isVertical()).isTrue();
        assertThat(Segment.create(3, 7, 8, 11).isVertical()).isFalse();
    }

    @Test
    void should_get_horizontal_segment_y_coordinate() {
        Segment segment = Segment.create(3, 7, 10, 7);

        assertThat(segment.y()).isEqualTo(7);
    }

    @Test
    void should_get_horizontal_segmen_start_point() {
        Segment segment = Segment.create(3, 7, 10, 7);

        assertThat(segment.startPoint()).isEqualTo(3);
    }

    @Test
    void should_get_horizontal_segment_end_point() {
        Segment segment = Segment.create(3, 7, 10, 7);

        assertThat(segment.endPoint()).isEqualTo(10);
    }

    @Test
    void should_get_vertical_segment_x_coordinate() {
        Segment segment = Segment.create(3, 7, 3, 11);

        assertThat(segment.x()).isEqualTo(3);
    }

    @Test
    void should_get_vertical_segmen_start_point() {
        Segment segment = Segment.create(3, 7, 3, 11);

        assertThat(segment.startPoint()).isEqualTo(7);
    }

    @Test
    void should_get_vertical_segment_end_point() {
        Segment segment = Segment.create(3, 7, 3, 11);

        assertThat(segment.endPoint()).isEqualTo(11);
    }
}
