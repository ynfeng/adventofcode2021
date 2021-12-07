package day6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import utils.Datas;

class LanternfishesTest {

    @Test
    void should_spwan_new_fish() {
        Lanternfishes fishes = Lanternfishes.create(
            Lanternfish.create(0),
            Lanternfish.create(4));

        fishes.oneDayPassed();

        assertThat(fishes.toString()).isEqualTo("6,3,8");
    }

    @Test
    void new_fish_spwan_in_days_should_7_when_after_another_day() {
        Lanternfishes fishes = Lanternfishes.create(
            Lanternfish.create(0),
            Lanternfish.create(4));

        fishes.oneDayPassed();
        fishes.oneDayPassed();


        assertThat(fishes.toString()).isEqualTo("5,2,7");
    }

    @Test
    void full_test() {
        Lanternfishes fishes = Lanternfishes.create("3,4,3,1,2");

        fishes.passDays(18);

        assertThat(fishes.toString()).isEqualTo("6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8");
        assertThat(fishes.howManyFish()).isEqualTo(26);

        fishes.passDays(62);
        assertThat(fishes.howManyFish()).isEqualTo(5934);
    }


    @Test
    void should_get_answer() {
        List<String> input = Datas.fromResourceAsList("day6/data");
        Lanternfishes fishes = Lanternfishes.create(input.get(0));

        fishes.passDays(80);

        assertThat(fishes.howManyFish()).isEqualTo(365862);
    }
}
