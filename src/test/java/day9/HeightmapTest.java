package day9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HeightmapTest extends Inputs {

    @Test
    void should_count_low_points() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(heightmap.countLowPoints()).isEqualTo(4);
    }

    @Test
    void should_get_risk_levels_sum() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(heightmap.riskLevelsSum()).isEqualTo(15);
    }

    @Test
    void should_get_answer() {
        int[][] input = getInputs();

        Heightmap heightmap = Heightmap.create(input);

        assertThat(heightmap.riskLevelsSum()).isEqualTo(1698);
    }
}
