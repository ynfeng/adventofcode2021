package day3;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import utils.Datas;

class DiagnosticReportTest {

    @Test
    void should_get_gamma_rate() {
        Numbers numbers = getTestNumbers();

        DiagnosticReport diagnosticReport = new DiagnosticReport(numbers);

        int gammaRate = diagnosticReport.getGammaRate();

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

    private static Numbers getTestNumbers() {
        return Numbers.create(Lists.newArrayList(
            Number.of("00100"),
            Number.of("11110"),
            Number.of("10110"),
            Number.of("10111"),
            Number.of("10101"),
            Number.of("01111"),
            Number.of("00111"),
            Number.of("11100"),
            Number.of("10000"),
            Number.of("11001"),
            Number.of("00010"),
            Number.of("01010")));
    }
}
