package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DiagramTest {

    @Test
    void should_get_result() {
        Diagram diagram = createDiagram();

        assertThat(diagram.getResult()).isEqualTo(5);
    }

    public static Diagram createDiagram() {
        return Diagram.create(
            Segment.create("0,9 -> 5,9"),
            Segment.create("8,0 -> 0,8"),
            Segment.create("9,4 -> 3,4"),
            Segment.create("2,2 -> 2,1"),
            Segment.create("7,0 -> 7,4"),
            Segment.create("6,4 -> 2,0"),
            Segment.create("0,9 -> 2,9"),
            Segment.create("3,4 -> 1,4"),
            Segment.create("0,0 -> 8,8"),
            Segment.create("5,5 -> 8,2"));
    }
}
