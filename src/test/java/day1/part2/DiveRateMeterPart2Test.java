package day1.part2;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import day1.Datas;
import day1.DepthIncreaseReporter;
import day1.DiveRateMeter;
import day1.SonarSweep;
import org.junit.jupiter.api.Test;

class DiveRateMeterPart2Test {

    @Test
    void should_report_dive_rate() {
        SonarSweep sonarSweep = new WindowSonarSweep(Lists.newArrayList(
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

        assertThat(diveRate).isEqualTo(5);
    }

    @Test
    void should_report_dive_rate_with_real_data() {
        SonarSweep sonarSweep = new WindowSonarSweep(Datas.fromResourceAsList("day1/data.p2"));
        DepthIncreaseReporter depthIncreaseReport = new DepthIncreaseReporter();
        DiveRateMeter diveRateMeter = new DiveRateMeter(sonarSweep, depthIncreaseReport);

        int diveRate = diveRateMeter.measureDiveRate();

        assertThat(diveRate).isEqualTo(1395);
    }
}
