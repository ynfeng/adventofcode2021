package day5.part2;

import day5.Diagram;
import day5.Segment;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DiagramV2 extends Diagram {
    private DiagramV2(Segment[] segs) {
        super(segs);
        segments = Arrays.stream(segs)
            .filter(it -> it.isHorizontal() || it.isVertical() || it.isDiagonal())
            .collect(Collectors.toList());
    }

    public static DiagramV2 create(Segment... segments) {
        return new DiagramV2(segments);
    }
}
