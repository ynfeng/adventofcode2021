package day5;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.jupiter.api.Test;
import utils.Datas;

class DiagramTest {

    @Test
    void should_create_diagram() {
        Diagram diagram = createDiagram();

        assertThat(diagram).isNotNull();
    }

    @Test
    void should_get_diagram_value() {
        Diagram diagram = createDiagram();

        assertThat(diagram.getValue(0, 0)).isZero();
    }

    @Test
    void should_generate_horizontal_diagram() {
        Diagram diagram = createDiagram();

        assertThat(diagram.getValue(9, 0)).isEqualTo(2);
        assertThat(diagram.getValue(9, 1)).isEqualTo(2);
        assertThat(diagram.getValue(9, 2)).isEqualTo(2);
        assertThat(diagram.getValue(9, 3)).isEqualTo(1);
        assertThat(diagram.getValue(9, 4)).isEqualTo(1);
        assertThat(diagram.getValue(9, 5)).isEqualTo(1);
        assertThat(diagram.getValue(9, 6)).isZero();
        assertThat(diagram.getValue(9, 7)).isZero();
        assertThat(diagram.getValue(9, 8)).isZero();
        assertThat(diagram.getValue(9, 9)).isZero();
    }

    @Test
    void should_generate_vertical_diagram() {
        Diagram diagram = createDiagram();

        assertThat(diagram.getValue(0, 2)).isZero();
        assertThat(diagram.getValue(1, 2)).isEqualTo(1);
        assertThat(diagram.getValue(2, 2)).isEqualTo(1);
        assertThat(diagram.getValue(3, 2)).isZero();
        assertThat(diagram.getValue(4, 2)).isEqualTo(1);
        assertThat(diagram.getValue(5, 2)).isZero();
        assertThat(diagram.getValue(6, 2)).isZero();
        assertThat(diagram.getValue(7, 2)).isZero();
        assertThat(diagram.getValue(8, 2)).isZero();
        assertThat(diagram.getValue(9, 2)).isEqualTo(2);
    }

    @Test
    void should_get_result() {
        Diagram diagram = createDiagram();

        assertThat(diagram.getResult()).isEqualTo(5);
    }

    @Test
    void should_get_answer() {
        List<String> datas = Datas.fromResourceAsList("day5/data");
        List<Segment> segments = Lists.newArrayList();
        for (String line : datas) {
            String[] items = line.split("->");
            int x1 = Integer.valueOf(items[0].split(",")[0].trim());
            int x2 = Integer.valueOf(items[0].split(",")[1].trim());
            int y1 = Integer.valueOf(items[1].split(",")[0].trim());
            int y2 = Integer.valueOf(items[1].split(",")[1].trim());
            Segment segment = Segment.create(x1, x2, y1, y2);
            segments.add(segment);
        }

        Diagram diagram = Diagram.create(segments.toArray(new Segment[] {}));

        assertThat(diagram.getResult()).isEqualTo(8060);
    }

    private static Diagram createDiagram() {
        return Diagram.create(
            Segment.create(0, 9, 5, 9),
            Segment.create(8, 0, 0, 8),
            Segment.create(9, 4, 3, 4),
            Segment.create(2, 2, 2, 1),
            Segment.create(7, 0, 7, 4),
            Segment.create(6, 4, 2, 0),
            Segment.create(0, 9, 2, 9),
            Segment.create(3, 4, 1, 4),
            Segment.create(0, 0, 8, 8),
            Segment.create(5, 5, 8, 2));
    }
}
