package day8;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

class UniqueSignalPatternsTest {

    @Test
    void should_get_unique_singal_pattern_by_length() {
        UniqueSignalPatterns uniqueSignalPatterns = UniqueSignalPatterns.create("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb");

        assertThat(uniqueSignalPatterns.getByLength(2)).isEqualTo(Lists.newArrayList(UniqueSignalPattern.create("be")));
        assertThat(uniqueSignalPatterns.getByLength(6))
            .isEqualTo(Lists.newArrayList(
                UniqueSignalPattern.create("cbdgef"),
                UniqueSignalPattern.create("fgaecd"),
                UniqueSignalPattern.create("agebfd")
            ));
    }
}
