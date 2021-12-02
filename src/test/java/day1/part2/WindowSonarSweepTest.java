package day1.part2;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

class WindowSonarSweepTest {

    @Test
    void should_measure_with_window() {
        WindowSonarSweep windowSonarSweep = new WindowSonarSweep(Lists.newArrayList(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263"
        ));

        assertThat(windowSonarSweep.measureDepth()).isEqualTo(607);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(618);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(618);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(617);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(647);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(716);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(769);
        assertThat(windowSonarSweep.measureDepth()).isEqualTo(792);
    }

    @Test
    void should_negative_when_not_enough_measurements() {
        WindowSonarSweep windowSonarSweep = new WindowSonarSweep(Lists.newArrayList(
            "199",
            "200"));

        assertThat(windowSonarSweep.measureDepth()).isEqualTo(-1);
    }
}
