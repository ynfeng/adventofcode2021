package day9;

import com.google.common.collect.Queues;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import org.assertj.core.util.Sets;

public class Basin {
    private final Point centerPoint;

    public Basin(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public static Basin create(Point centerPoint) {
        return new Basin(centerPoint);
    }

    public int area() {
        Set<Point> pointsInBasin = Sets.newHashSet();

        Queue<Optional<Point>> points = Queues.newArrayDeque();
        points.offer(Optional.of(centerPoint));

        while (!points.isEmpty()) {
            Optional<Point> pointCandidate = points.poll();

            if (pointCandidate.isPresent()) {
                Point point = pointCandidate.get();

                points.offer(point.leftSide());
                points.offer(point.rightSide());
                points.offer(point.top());
                points.offer(point.bottom());

                pointsInBasin.add(point);
            }
        }

        return pointsInBasin.size();
    }
}
