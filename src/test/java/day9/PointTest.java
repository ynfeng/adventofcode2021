package day9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void should_not_low_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(Point.create(heightmap, 0, 0).isLowPoint()).isEqualTo(false);
        assertThat(Point.create(heightmap, 3, 1).isLowPoint()).isEqualTo(false);
        assertThat(Point.create(heightmap, 0, 1).isLowPoint()).isEqualTo(false);
    }

    @Test
    void should_low_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(Point.create(heightmap, 1, 0).isLowPoint()).isEqualTo(true);
        assertThat(Point.create(heightmap, 9, 0).isLowPoint()).isEqualTo(true);
        assertThat(Point.create(heightmap, 2, 2).isLowPoint()).isEqualTo(true);
        assertThat(Point.create(heightmap, 6, 4).isLowPoint()).isEqualTo(true);
    }

    @Test
    void should_get_height() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(Point.create(heightmap, 1, 0).height()).isEqualTo(1);
        assertThat(Point.create(heightmap, 9, 0).height()).isEqualTo(0);
        assertThat(Point.create(heightmap, 2, 2).height()).isEqualTo(5);
        assertThat(Point.create(heightmap, 6, 4).height()).isEqualTo(5);
    }
}
