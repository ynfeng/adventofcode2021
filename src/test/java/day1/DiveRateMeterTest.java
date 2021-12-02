package day1;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

class DiveRateMeterTest {

    @Test
    void should_report_dive_rate() {
        SonarSweep sonarSweep = new DefaultSonarSweep(Lists.newArrayList(
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
        DepthIncreaseReporter depthIncreaseReport = new DepthIncreaseReporter();

        DiveRateMeter diveRateMeter = new DiveRateMeter(sonarSweep, depthIncreaseReport);

        int diveRate = diveRateMeter.measureDiveRate();

        assertThat(diveRate).isEqualTo(7);
    }

    @Test
    void should_report_dive_rate_with_real_data() {
        SonarSweep sonarSweep = new DefaultSonarSweep(Datas.fromResourceAsList("day1/data"));
        DepthIncreaseReporter depthIncreaseReport = new DepthIncreaseReporter();
        DiveRateMeter diveRateMeter = new DiveRateMeter(sonarSweep, depthIncreaseReport);

        int diveRate = diveRateMeter.measureDiveRate();

        assertThat(diveRate).isEqualTo(1451);
    }

}
