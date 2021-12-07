package day6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LanternfishTest {

    @Test
    void should_create() {
        Lanternfish lanternfish = Lanternfish.create(2);

        assertThat(lanternfish).isNotNull();
    }

    @Test
    void spawn_in_days_should_become_1_after_one_days() {
        Lanternfish lanternfish = Lanternfish.create(2);

        lanternfish.oneDayPassed();

        assertThat(lanternfish.spawnInDays()).isEqualTo(1);
    }

    @Test
    void spawn_in_days_should_reset_to_6_when_spawn_in_days_was_0() {
        Lanternfish lanternfish = Lanternfish.create(0);

        lanternfish.oneDayPassed();

        assertThat(lanternfish.spawnInDays()).isEqualTo(6);
    }
}
