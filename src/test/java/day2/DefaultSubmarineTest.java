package day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DefaultSubmarineTest {

    @Test
    void should_forward() {
        Submarine submarine = new DefaultSubmarine();

        assertThat(submarine.forward(5).horizontal()).isEqualTo(5);
        assertThat(submarine.forward(1).horizontal()).isEqualTo(6);
        assertThat(submarine.forward(11).horizontal()).isEqualTo(17);
    }

    @Test
    void should_down() {
        Submarine submarine = new DefaultSubmarine();

        assertThat(submarine.down(5).depth()).isEqualTo(5);
        assertThat(submarine.down(5).depth()).isEqualTo(10);
        assertThat(submarine.down(1).depth()).isEqualTo(11);
    }

    @Test
    void should_up() {
        Submarine submarine = new DefaultSubmarine();

        assertThat(submarine.down(5).depth()).isEqualTo(5);
        assertThat(submarine.up(5).depth()).isZero();
        assertThat(submarine.up(5).depth()).isZero();
    }
}
