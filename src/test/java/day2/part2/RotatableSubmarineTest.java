package day2.part2;

import static org.assertj.core.api.Assertions.assertThat;

import day2.Command;
import day2.Submarine;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import utils.Datas;

class RotatableSubmarineTest {

    @Test
    void should_down() {
        RotatableSubmarine submarine = new RotatableSubmarine();

        submarine.down(5);

        assertThat(submarine.aim()).isEqualTo(5);
    }

    @Test
    void should_up() {
        RotatableSubmarine submarine = new RotatableSubmarine();

        submarine.down(5);
        submarine.up(5);

        assertThat(submarine.aim()).isEqualTo(0);
    }

    @Test
    void should_0_when_aim_was_0() {
        RotatableSubmarine submarine = new RotatableSubmarine();

        submarine.up(5);

        assertThat(submarine.aim()).isEqualTo(0);
    }

    @Test
    void should_forward_when_aim_was_0() {
        RotatableSubmarine submarine = new RotatableSubmarine();

        submarine.forward(5);

        assertThat(submarine.horizontal()).isEqualTo(5);
    }

    @Test
    void should_forward_when_aim_was_2() {
        RotatableSubmarine submarine = new RotatableSubmarine();

        submarine.down(2);
        submarine.forward(5);

        assertThat(submarine.horizontal()).isEqualTo(5);
        assertThat(submarine.depth()).isEqualTo(10);
    }

    @Test
    void should_move_correct() {
        RotatableSubmarine submarine = new RotatableSubmarine();

        submarine.forward(5);
        assertThat(submarine.horizontal()).isEqualTo(5);

        submarine.down(5);
        assertThat(submarine.aim()).isEqualTo(5);

        submarine.forward(8);
        assertThat(submarine.horizontal()).isEqualTo(13);
        assertThat(submarine.depth()).isEqualTo(40);

        submarine.up(3);
        assertThat(submarine.aim()).isEqualTo(2);

        submarine.down(8);
        assertThat(submarine.aim()).isEqualTo(10);

        submarine.forward(2);
        assertThat(submarine.horizontal()).isEqualTo(15);
        assertThat(submarine.depth()).isEqualTo(60);

        assertThat(submarine.positionTotal()).isEqualTo(900);
    }

    @Test
    void should_get_answer() {
        Submarine submarine = new RotatableSubmarine();
        Command[] commands = Command.create(Datas.fromResourceAsList("day2/data.p2"));
        Arrays.stream(commands).forEach(submarine::executeCommand);

        assertThat(submarine.positionTotal()).isEqualTo(1604592846);
    }
}
