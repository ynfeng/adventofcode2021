package day10;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    @ParameterizedTest
    @CsvSource( {
        "{([(<{}[<>[]}>{[]{[(<()>, true",
        "[[<[([]))<([[{}[[()]]], true",
        "[{[{({}]{}}([{[{{{}}([], true",
        "[<(<(<(<{}))><([]([](), true",
        "<{([([[(<>()){}]>(<<{{, true",
        "[({(<(())[]>[[{[]{<()<>>, false",
        "[(()[<>])]({[<{<<[]>>(, false",
        "(((({<>}<{<{<>}{[]{[]{}, false ",
        "{<[[]]>}<{[{[{[]{()[[[], false ",
        "<{([{{}}[<[[[<>{}]]]>[]], false",
    })
    void should_detect_if_corrupted(String line, boolean isCorrupted) {
        assertThat(Chunks.create(line).isCorrupted()).isEqualTo(isCorrupted);
    }

    @ParameterizedTest
    @CsvSource( {
        "(, )",
        "[({(<(())[]>[[{[]{<()<>>, }}]])})]",
        "[(()[<>])]({[<{<<[]>>(, )}>]})",
        "(((({<>}<{<{<>}{[]{[]{}, }}>}>))))",
        "{<[[]]>}<{[{[{[]{()[[[], ]]}}]}]}>",
        "<{([{{}}[<[[[<>{}]]]>[]], ])}>",
    })
    void should_get_complete_chunk_chars(String line, String completeChars) {
        ChunkChar[] chunkChars = IntStream.range(0, completeChars.length())
            .mapToObj(i -> ChunkChar.of(completeChars.charAt(i)))
            .collect(Collectors.toList())
            .toArray(new ChunkChar[] {});

        assertThat(Chunks.create(line).completeChars()).isEqualTo(chunkChars);
    }

    @ParameterizedTest
    @CsvSource( {
        "[({(<(())[]>[[{[]{<()<>>,288957",
        "[(()[<>])]({[<{<<[]>>(,5566",
        "(((({<>}<{<{<>}{[]{[]{},1480781",
        "{<[[]]>}<{[{[{[]{()[[[],995444",
        "<{([{{}}[<[[[<>{}]]]>[]],294"
    })
    void should_get_complete_points(String line, int points) {
        assertThat(Chunks.create(line).completePoints()).isEqualTo(points);
    }
}
