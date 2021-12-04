package day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import utils.Datas;

class DiagnosticReportTest extends NumbersTestSupport {

    @Test
    void should_get_gamma_rate() {
        Numbers numbers = getTestNumbers();

        DiagnosticReport diagnosticReport = new DiagnosticReport(numbers);

        int gammaRate = diagnosticReport.gammaRate();

        assertThat(gammaRate).isEqualTo(22);
    }

    @Test
    void should_get_epsilon_rate() {
        Numbers numbers = getTestNumbers();

        DiagnosticReport diagnosticReport = new DiagnosticReport(numbers);

        int epsilonRate = diagnosticReport.epsilonRate();

        assertThat(epsilonRate).isEqualTo(9);
    }

    @Test
    void should_get_result() {
        Numbers numbers = getTestNumbers();

        DiagnosticReport diagnosticReport = new DiagnosticReport(numbers);

        assertThat(diagnosticReport.getResult()).isEqualTo(198);
    }

    @Test
    void should_get_answer() {
        List<Number> nums = Datas.fromResourceAsList("day3/data")
            .stream()
            .map(Number::of)
            .collect(Collectors.toList());
        DiagnosticReport report = new DiagnosticReport(Numbers.create(nums));

        assertThat(report.getResult()).isEqualTo(2967914);
    }

}
