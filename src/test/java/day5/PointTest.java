package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void should_create_point() {
        Point point = Point.of(1, 2);

        assertThat(point.x()).isEqualTo(1);
        assertThat(point.y()).isEqualTo(2);
    }
}
