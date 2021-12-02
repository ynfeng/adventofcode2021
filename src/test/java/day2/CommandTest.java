package day2;

import static day2.Direction.DOWN;
import static day2.Direction.FORWARD;
import static day2.Direction.UP;
import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import utils.Datas;

class CommandTest {

    @Test
    void should_parse_forward_command() {
        Command command = Command.create("forward 5");

        assertThat(command.direction()).isEqualTo(FORWARD);
        assertThat(command.distance()).isEqualTo(5);
    }

    @Test
    void should_parse_up_command() {
        Command command = Command.create("up 3");

        assertThat(command.direction()).isEqualTo(UP);
        assertThat(command.distance()).isEqualTo(3);
    }

    @Test
    void should_parse_down_command() {
        Command command = Command.create("down 3");

        assertThat(command.direction()).isEqualTo(DOWN);
        assertThat(command.distance()).isEqualTo(3);
    }

    @Test
    void should_execute_command() {
        Submarine submarine = new Submarine();

        submarine.executeCommand(Command.create("forward 1"));
        submarine.executeCommand(Command.create("forward 1"));
        submarine.executeCommand(Command.create("down 5"));
        submarine.executeCommand(Command.create("up 1"));

        Position position = submarine.position();
        assertThat(position.horizontal()).isEqualTo(2);
        assertThat(position.depth()).isEqualTo(4);
    }

    @Test
    void should_parse_multi_command() {
        Command[] commands = Command.create(Lists.newArrayList("forward 1", "up 2", "down 3"));

        assertThat(commands.length).isEqualTo(3);
        assertThat(commands[0].direction()).isEqualTo(FORWARD);
        assertThat(commands[0].distance()).isEqualTo(1);
        assertThat(commands[1].direction()).isEqualTo(UP);
        assertThat(commands[1].distance()).isEqualTo(2);
        assertThat(commands[2].direction()).isEqualTo(DOWN);
        assertThat(commands[2].distance()).isEqualTo(3);
    }

    @Test
    void should_get_answer() {
        Submarine submarine = new Submarine();
        Command[] commands = Command.create(Datas.fromResourceAsList("day2/data"));
        Arrays.stream(commands).forEach(submarine::executeCommand);

        Position position = submarine.position();
        assertThat(position.depth() * position.horizontal()).isEqualTo(1660158);
    }
}
