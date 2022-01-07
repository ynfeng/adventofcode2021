package day10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChunkCharTest {

    @ParameterizedTest
    @CsvSource( {
        "(,), true",
        "[,], true",
        "{,}, true",
        "<,>, true",
        "<,], false"
    })
    void should_test_pair(char open, char close, boolean expected) {
        assertThat(ChunkChar.of(open).isPair(close)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource( {
        "(,true",
        "[,true",
        "{,true",
        "<,true",
        "},false",
        "],false"
    })
    void should_test_is_open(char ch, boolean isOpen) {
        assertThat(ChunkChar.of(ch).isOpen()).isEqualTo(isOpen);
    }

    @ParameterizedTest
    @CsvSource( {
        "(,)",
        "[,]",
        "{,}",
        "<,>",
        "}, ' '",
        "], ' '"
    })
    void should_get_pair_char(char open, char exptected) {
        assertThat(ChunkChar.of(open).closeChar()).isEqualTo(exptected);
    }

    @ParameterizedTest
    @CsvSource( {
        "),3",
        "],57",
        "},1197",
        ">,25137 ",
        "' ', 0",
    })
    void should_get_corrupted_points(char ch, int points) {
        assertThat(ChunkChar.of(ch).corruptedPoints()).isEqualTo(points);
    }

    @ParameterizedTest
    @CsvSource( {
        "),1",
        "],2",
        "},3",
        ">,4",
        "(,0"
    })
    void should_get_complete_points(char ch, int points) {
        assertThat(ChunkChar.of(ch).completePoints()).isEqualTo(points);
    }
}
