package day9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BasinsTest extends Inputs {

    @Test
    void should_multiply_three_largest_basins_size() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        Basins basins = Basins.create(heightmap);

        assertThat(basins.risk()).isEqualTo(1134);
    }

    @Test
    void should_get_part2_answer() {
        Heightmap heightmap = Heightmap.create(getInputs());

        Basins basins = Basins.create(heightmap);

        assertThat(basins.risk()).isEqualTo(1280496);
    }
}
