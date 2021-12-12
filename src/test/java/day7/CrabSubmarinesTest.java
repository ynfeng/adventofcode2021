package day7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import utils.Datas;

class CrabSubmarinesTest {

    @Test
    void should_align_with_example() {
        CrabSubmarines crabSubmarines = getCrabSubmarines();

        assertThat(crabSubmarines.leastFuelSpend()).isEqualTo(37);
    }

    @Test
    void should_get_answer() {
        int[] inputs = Arrays.stream(Datas.fromResourceAsList("day7/data")
                .get(0)
                .split(","))
            .mapToInt(Integer::valueOf)
            .toArray();

        CrabSubmarines crabSubmarines = CrabSubmarines.create(inputs);

        assertThat(crabSubmarines.leastFuelSpend()).isEqualTo(356992);
    }

    @Test
    void should_41_fuel_cost_to_position_1() {
        CrabSubmarines crabSubmarines = getCrabSubmarines();

        assertThat(crabSubmarines.toPosition(1)).isEqualTo(41);
    }

    @Test
    void should_39_fuel_cost_to_position_3() {
        CrabSubmarines crabSubmarines = getCrabSubmarines();

        assertThat(crabSubmarines.toPosition(3)).isEqualTo(39);
    }

    private CrabSubmarines getCrabSubmarines() {
        return CrabSubmarines.create(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
    }
}
