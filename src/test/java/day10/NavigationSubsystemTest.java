package day10;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import utils.Datas;

class NavigationSubsystemTest {

    @Test
    void should_get_points() {
        NavigationSubsystem navigationSubsystem = NavigationSubsystem.of(
            "{([(<{}[<>[]}>{[]{[(<()>",
            "[[<[([]))<([[{}[[()]]]",
            "[{[{({}]{}}([{[{{{}}([]",
            "[<(<(<(<{}))><([]([]()",
            "<{([([[(<>()){}]>(<<{{"
        );

        assertThat(navigationSubsystem.points()).isEqualTo(26397);
    }

    @Test
    void should_get_answer_of_part_1() {
        List<String> lines = Datas.fromResourceAsList("day10/data");
        NavigationSubsystem navigationSubsystem = NavigationSubsystem.of(lines.toArray(new String[] {}));

        assertThat(navigationSubsystem.points()).isEqualTo(323613);
    }
}
