package day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class
SegmentTest {
    @Test
    void should_create_segment() {
        Segment segment = Segment.create(0, 0, 0, 2);

        assertThat(segment).isNotNull();
    }

    @Test
    void should_create_segment_from_string() {
        Segment segment = Segment.create("2,2 -> 5,2");

        Point[] points = segment.points();

        assertThat(points).isEqualTo(new Point[] {
            Point.of(2, 2),
            Point.of(3, 2),
            Point.of(4, 2),
            Point.of(5, 2)});
    }

    @Test
    void should_get_points_when_segment_was_horizontal() {
        Segment segment = Segment.create(2, 2, 5, 2);
        Point[] points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(2, 2),
            Point.of(3, 2),
            Point.of(4, 2),
            Point.of(5, 2)});

        segment = Segment.create(9, 4, 3, 4);
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(3, 4),
            Point.of(4, 4),
            Point.of(5, 4),
            Point.of(6, 4),
            Point.of(7, 4),
            Point.of(8, 4),
            Point.of(9, 4)
        });
    }

    @Test
    void should_get_points_when_segment_was_vertical() {
        Segment segment = Segment.create(3, 3, 3, 6);
        Point[] points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(3, 3),
            Point.of(3, 4),
            Point.of(3, 5),
            Point.of(3, 6)});

        segment = Segment.create(7, 4, 7, 0);
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(7, 0),
            Point.of(7, 1),
            Point.of(7, 2),
            Point.of(7, 3),
            Point.of(7, 4),
        });
    }

    @Test
    void should_get_points_when_segment_was_diagonal() {
        Segment segment;
        Point[] points;

        segment = Segment.create(1, 1, 3, 3);
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(1, 1),
            Point.of(2, 2),
            Point.of(3, 3),
        });

        segment = Segment.create(5, 5, 1, 1);
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(1, 1),
            Point.of(2, 2),
            Point.of(3, 3),
            Point.of(4, 4),
            Point.of(5, 5),
        });

        segment = Segment.create(9, 7, 7, 9);
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(7, 9),
            Point.of(8, 8),
            Point.of(9, 7),
        });

        segment = Segment.create(7, 9, 9, 7);
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(7, 9),
            Point.of(8, 8),
            Point.of(9, 7),
        });

        segment = Segment.create("6,4 -> 2,0");
        points = segment.points();
        assertThat(points).isEqualTo(new Point[] {
            Point.of(2, 0),
            Point.of(3, 1),
            Point.of(4, 2),
            Point.of(5, 3),
            Point.of(6, 4),
        });
    }
}
