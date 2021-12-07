package day5;

import static org.assertj.core.api.Assertions.assertThat;

import day5.part2.DiagramV2;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import utils.Datas;

class DiagramTest {

    @Test
    void should_get_result() {
        Diagram diagram = createDiagram();

        int result = diagram.getResult();

        diagram.draw(10);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void should_get_result_part2() {
        DiagramV2 diagram = DiagramV2.create(getSegments());

        int result = diagram.getResult();

        diagram.draw(10);
        assertThat(result).isEqualTo(12);
    }

    @Test
    void should_get_answer() {
        List<Segment> segments = Datas.fromResourceAsList("day5/data")
            .stream()
            .map(Segment::create)
            .collect(Collectors.toList());
        Diagram diagram = Diagram.create(segments.toArray(new Segment[] {}));

        assertThat(diagram.getResult()).isEqualTo(8060);
    }

    @Test
    void should_get_part2_answer() {
        List<Segment> segments = Datas.fromResourceAsList("day5/data")
            .stream()
            .map(Segment::create)
            .collect(Collectors.toList());
        DiagramV2 diagram = DiagramV2.create(segments.toArray(new Segment[] {}));

        assertThat(diagram.getResult()).isEqualTo(21577);
    }

    public static Diagram createDiagram() {
        return Diagram.create(getSegments());
    }

    private static Segment[] getSegments() {
        return new Segment[] {Segment.create("0,9 -> 5,9"),
            Segment.create("8,0 -> 0,8"),
            Segment.create("9,4 -> 3,4"),
            Segment.create("2,2 -> 2,1"),
            Segment.create("7,0 -> 7,4"),
            Segment.create("6,4 -> 2,0"),
            Segment.create("0,9 -> 2,9"),
            Segment.create("3,4 -> 1,4"),
            Segment.create("0,0 -> 8,8"),
            Segment.create("5,5 -> 8,2")};
    }
}
