package day10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChunksTest {

    @ParameterizedTest
    @CsvSource( {
        "{([(<{}[<>[]}>{[]{[(<()>, }",
        "[[<[([]))<([[{}[[()]]], )",
        "[{[{({}]{}}([{[{{{}}([], ]",
        "[<(<(<(<{}))><([]([](), )",
        "<{([([[(<>()){}]>(<<{{, >"
    })
    void should_detect_missed_char(String input, char expectedChar) {
        assertThat(Chunks.create(input).missed()).isEqualTo(ChunkChar.of(expectedChar));
    }
}
