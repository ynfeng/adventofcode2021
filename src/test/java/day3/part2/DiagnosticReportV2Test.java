package day3.part2;

import static org.assertj.core.api.Assertions.assertThat;

import day3.Number;
import day3.NumbersTestSupport;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Datas;

class DiagnosticReportV2Test extends NumbersTestSupport {

    @Test
    void should_get_oxygen_generator_rating() {
        NumbersV2 numbers = NumbersV2.create(getNumberList());
        DiagnosticReportV2 reportV2 = new DiagnosticReportV2(numbers);

        assertThat(reportV2.getOxygenGeneratorRating()).isEqualTo(23);
    }

    @Test
    void should_get_co2_scrubber_rating() {
        NumbersV2 numbers = NumbersV2.create(getNumberList());
        DiagnosticReportV2 reportV2 = new DiagnosticReportV2(numbers);

        assertThat(reportV2.getCo2ScrubberRating()).isEqualTo(10);
    }

    @Test
    @Disabled
    void should_get_result() {
        NumbersV2 numbers = NumbersV2.create(getNumberList());
        DiagnosticReportV2 reportV2 = new DiagnosticReportV2(numbers);

        assertThat(reportV2.getCo2ScrubberRating()).isEqualTo(10);
        assertThat(reportV2.getOxygenGeneratorRating()).isEqualTo(23);
        assertThat(reportV2.getResult()).isEqualTo(230);
    }

    @Test
    void should_get_answer() {
        List<Number> nums = Datas.fromResourceAsList("day3/data")
            .stream()
            .map(Number::of)
            .collect(Collectors.toList());
        DiagnosticReportV2 report = new DiagnosticReportV2(NumbersV2.create(nums));

        assertThat(report.getResult()).isEqualTo(7041258);
    }
}
