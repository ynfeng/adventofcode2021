package day6.part2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import utils.Datas;

class LanternfishesV2Test {

    @Test
    void should_get_result() {
        LanternfishesV2 lanternfishes = LanternfishesV2.create(3, 4, 3, 1, 2);

        lanternfishes.passDays(80);

        assertThat(lanternfishes.howManyFishes()).isEqualTo(5934);
    }

    @Test
    void should_get_answer_v2() {
        int[] fishes = Arrays.stream(Datas.fromResourceAsList("day6/data")
                .get(0)
                .split(","))
            .mapToInt(Integer::valueOf)
            .toArray();

        LanternfishesV2 lanternfishes = LanternfishesV2.create(fishes);

        lanternfishes.passDays(256);

        assertThat(lanternfishes.howManyFishes()).isEqualTo(1653250886439L);
    }
}
