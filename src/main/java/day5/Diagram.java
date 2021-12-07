package day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Diagram {
    protected List<Segment> segments;
    private final int[][] map = new int[1000][1000];

    public Diagram(Segment[] segs) {
        segments = Arrays.stream(segs)
            .filter(it -> it.isHorizontal() || it.isVertical())
            .collect(Collectors.toList());
    }

    public static Diagram create(Segment... segments) {
        return new Diagram(segments);
    }

    public int getResult() {
        segments.stream()
            .forEach(segment -> {
                for (Point point : segment.points()) {
                    map[point.y()][point.x()]++;
                }
            });

        int result = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (map[i][j] >= 2) {
                    result++;
                }
            }
        }

        return result;
    }

    public void draw(int col) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                String p = map[i][j] == 0 ? "." : String.valueOf(map[i][j]);
                System.out.print(p);
            }
            System.out.println();
        }
    }
}
