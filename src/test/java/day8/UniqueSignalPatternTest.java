package day8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UniqueSignalPatternTest {

    @Test
    void should_exclude_chars() {
        UniqueSignalPattern pattern = UniqueSignalPattern.create("edb");

        assertThat(pattern.exclude('b', 'e')).isEqualTo(UniqueSignalPattern.create("d"));
    }

    @Test
    void should_intersect_chars() {
        UniqueSignalPattern pattern = UniqueSignalPattern.create("dab");

        assertThat(pattern.intersect('f', 'b', 'c', 'a', 'd')).isEqualTo(UniqueSignalPattern.create("dab"));
    }

    @Test
    void should_count_intersect() {
        UniqueSignalPattern pattern = UniqueSignalPattern.create("edb");

        assertThat(pattern.countIntersect('d', 'b')).isEqualTo(2);
    }
}
