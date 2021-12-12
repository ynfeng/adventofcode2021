package day7.part2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import utils.Datas;

class CrabSubmarinesV2Test {

    @Test
    void should_206_fuel_cost_to_position_2() {
        CrabSubmarinesV2 crabSubmarines = CrabSubmarinesV2.create(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);

        assertThat(crabSubmarines.toPosition(2)).isEqualTo(206);
    }

    @Test
    void should_get_answer_for_part2() {
        int[] inputs = Arrays.stream(Datas.fromResourceAsList("day7/data")
                .get(0)
                .split(","))
            .mapToInt(Integer::valueOf)
            .toArray();

        CrabSubmarinesV2 crabSubmarines = CrabSubmarinesV2.create(inputs);

        assertThat(crabSubmarines.leastFuelSpend()).isEqualTo(101268110);
    }
}
