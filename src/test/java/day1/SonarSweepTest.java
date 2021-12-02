package day1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SonarSweepTest {

    @Test
    void should_measure_depth() {
        SonarSweep sonarSweep = new DefaultSonarSweep(Datas.fromResourceAsList("day1/data"));

        assertThat(sonarSweep.measureDepth()).isEqualTo(159);
        assertThat(sonarSweep.measureDepth()).isEqualTo(170);
        assertThat(sonarSweep.measureDepth()).isEqualTo(171);
        assertThat(sonarSweep.measureDepth()).isEqualTo(170);
    }

    @Test
    void should_negative_when_no_more_depth_data() {
        SonarSweep sonarSweep = new DefaultSonarSweep(Datas.fromResourceAsList("day1/data"));

        for (int i = 0; i < 2000; i++) {
            sonarSweep.measureDepth();
        }

        assertThat(sonarSweep.measureDepth()).isEqualTo(-1);
    }
}
