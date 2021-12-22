package day9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void should_not_low_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(Point.create(heightmap, 0, 0).isLowPoint()).isEqualTo(false);
        assertThat(Point.create(heightmap, 3, 1).isLowPoint()).isEqualTo(false);
        assertThat(Point.create(heightmap, 0, 1).isLowPoint()).isEqualTo(false);
    }

    @Test
    void should_low_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(Point.create(heightmap, 1, 0).isLowPoint()).isEqualTo(true);
        assertThat(Point.create(heightmap, 9, 0).isLowPoint()).isEqualTo(true);
        assertThat(Point.create(heightmap, 2, 2).isLowPoint()).isEqualTo(true);
        assertThat(Point.create(heightmap, 6, 4).isLowPoint()).isEqualTo(true);
    }

    @Test
    void should_get_height() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        assertThat(Point.create(heightmap, 1, 0).height()).isEqualTo(1);
        assertThat(Point.create(heightmap, 9, 0).height()).isEqualTo(0);
        assertThat(Point.create(heightmap, 2, 2).height()).isEqualTo(5);
        assertThat(Point.create(heightmap, 6, 4).height()).isEqualTo(5);
    }

    @Test
    void should_get_left_side_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        Optional<Point> leftSidePointCandidate = Point.create(heightmap, 9, 0).leftSide();
        assertThat(leftSidePointCandidate.get().height()).isEqualTo(1);

        leftSidePointCandidate = Point.create(heightmap, 0, 0).leftSide();
        assertThat(leftSidePointCandidate.isPresent()).isEqualTo(false);

        leftSidePointCandidate = Point.create(heightmap, 1, 1).leftSide();
        assertThat(leftSidePointCandidate.isPresent()).isEqualTo(false);

        leftSidePointCandidate = Point.create(heightmap, 5, 0).leftSide();
        assertThat(leftSidePointCandidate.isPresent()).isEqualTo(false);
    }

    @Test
    void should_get_top_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        Optional<Point> topPointCandidate = Point.create(heightmap, 8, 4).top();
        assertThat(topPointCandidate.get().height()).isEqualTo(8);

        topPointCandidate = Point.create(heightmap, 0, 0).top();
        assertThat(topPointCandidate.isPresent()).isEqualTo(false);

        topPointCandidate = Point.create(heightmap, 9, 1).top();
        assertThat(topPointCandidate.isPresent()).isEqualTo(false);

        topPointCandidate = Point.create(heightmap, 2, 1).top();
        assertThat(topPointCandidate.isPresent()).isEqualTo(false);
    }

    @Test
    void should_get_right_side_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        Optional<Point> rightPointCandidate = Point.create(heightmap, 7, 3).rightSide();
        assertThat(rightPointCandidate.get().height()).isEqualTo(8);

        rightPointCandidate = Point.create(heightmap, 9, 0).rightSide();
        assertThat(rightPointCandidate.isPresent()).isEqualTo(false);

        rightPointCandidate = Point.create(heightmap, 0, 0).rightSide();
        assertThat(rightPointCandidate.isPresent()).isEqualTo(false);

        rightPointCandidate = Point.create(heightmap, 0, 1).rightSide();
        assertThat(rightPointCandidate.isPresent()).isEqualTo(false);
    }

    @Test
    void should_get_bottom_point() {
        Heightmap heightmap = Heightmap.create(Constants.HEIGHT_MAP);

        Optional<Point> bottomPointCandidate = Point.create(heightmap, 8, 0).bottom();
        assertThat(bottomPointCandidate.get().height()).isEqualTo(2);

        bottomPointCandidate = Point.create(heightmap, 9, 4).bottom();
        assertThat(bottomPointCandidate.isPresent()).isEqualTo(false);

        bottomPointCandidate = Point.create(heightmap, 2, 0).bottom();
        assertThat(bottomPointCandidate.isPresent()).isEqualTo(false);

        bottomPointCandidate = Point.create(heightmap, 0, 3).bottom();
        assertThat(bottomPointCandidate.isPresent()).isEqualTo(false);
    }
}
