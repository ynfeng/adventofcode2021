package day9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BasinTest extends Inputs {

    @Test
    void should_measured_left_top_basin_area() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);
        Point centerPoint = Point.create(heightmap, 1, 0);

        Basin basin = Basin.create(centerPoint);

        assertThat(basin.area()).isEqualTo(3);
    }


    @Test
    void should_measured_top_right_basin_area() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);
        Point centerPoint = Point.create(heightmap, 9, 0);

        Basin basin = Basin.create(centerPoint);

        assertThat(basin.area()).isEqualTo(9);
    }

    @Test
    void should_measured_middle_basin_area() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);
        Point centerPoint = Point.create(heightmap, 2, 2);

        Basin basin = Basin.create(centerPoint);

        assertThat(basin.area()).isEqualTo(14);
    }

    @Test
    void should_measured_bottom_right_basin_area() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);
        Point centerPoint = Point.create(heightmap, 6, 4);

        Basin basin = Basin.create(centerPoint);

        assertThat(basin.area()).isEqualTo(9);
    }
}
