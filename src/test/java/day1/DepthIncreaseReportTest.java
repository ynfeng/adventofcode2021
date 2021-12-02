package day1;

import static day1.DepthIncreaseResult.DECREASED;
import static day1.DepthIncreaseResult.INCREASED;
import static day1.DepthIncreaseResult.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DepthIncreaseReportTest {

    @Test
    void should_report_none_when_first_scan() {
        DepthIncreaseReporter reporter = new DepthIncreaseReporter();

        DepthIncreaseResult result = reporter.scan(199);

        assertThat(result).isEqualTo(NONE);
    }

    @Test
    void should_report_increased() {
        DepthIncreaseReporter reporter = new DepthIncreaseReporter();

        reporter.scan(199);
        DepthIncreaseResult result = reporter.scan(200);

        assertThat(result).isEqualTo(INCREASED);
    }

    @Test
    void should_report_decreased() {
        DepthIncreaseReporter reporter = new DepthIncreaseReporter();

        reporter.scan(199);
        DepthIncreaseResult result = reporter.scan(198);

        assertThat(result).isEqualTo(DECREASED);
    }
}
