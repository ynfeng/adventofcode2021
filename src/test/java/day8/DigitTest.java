package day8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DigitTest {
    @Test
    void should_count_unique_number_of_segments() {
        Digit digit = Digit.create("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");

        assertThat(digit.countUniqueNumberOfSegments()).isEqualTo(2);
    }

    @Test
    void should_analysis_segments_from_1() {
        Digit digit = Digit.create("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        assertThat(digit.configuration().charAt(2)).isEqualTo('a');
        assertThat(digit.configuration().charAt(3)).isEqualTo('b');
    }

    @Test
    void should_analysis_segments_from_7() {
        Digit digit = Digit.create("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        assertThat(digit.configuration().charAt(1)).isEqualTo('d');
    }

    @Test
    void should_analysis_segments_from_4() {
        Digit digit = Digit.create("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        assertThat(digit.configuration().charAt(6)).isEqualTo('f');
        assertThat(digit.configuration().charAt(4)).isEqualTo('c');
        assertThat(digit.configuration().charAt(0)).isEqualTo('e');
    }

    @Test
    void should_analysis_segments_form_8() {
        Digit digit = Digit.create("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        assertThat(digit.configuration().charAt(5)).isEqualTo('g');
    }

    @Test
    void should_analysis_configurations() {
        Digit digit = Digit.create("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        assertThat(digit.configuration()).isEqualTo("edabcgf");
    }

    @ParameterizedTest
    @CsvSource( {
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cefabd, 9",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | acedgfb, 8",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | dab, 7",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfgeb, 6",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfbe, 5",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | eafb, 4",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | fbcad, 3",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | gcdfa, 2",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | ab, 1",
        "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cagedb, 0",
    })
    void should_get_single_number(String input, int expect) {
        Digit digit = Digit.create(input);

        assertThat(digit.number()).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource( {
        "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe,8394 ",
        "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc,9781",
        "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg,1197",
        "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb,9361",
        "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea,4873",
        "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb,8418",
        "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe,4548",
        "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef,1625",
        "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb,8717",
        "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce,4315"
    })
    void should_get_multi_number(String input, int expect) {
        Digit digit = Digit.create(input);

        assertThat(digit.number()).isEqualTo(expect);
    }
}
