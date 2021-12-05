package day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Diagram {
    private final int[][] diagramData = new int[1000][1000];

    public Diagram(Segment[] segments) {
        List<Segment> segmentList = Arrays.stream(segments)
            .filter(it -> it.isHorizontal() || it.isVertical())
            .collect(Collectors.toList());

        generateData(segmentList);
    }

    private void generateData(List<Segment> segmentList) {
        gererateHorizontalData(segmentList);
        gererateVerticallData(segmentList);
    }

    private void gererateVerticallData(List<Segment> segmentList) {
        segmentList.stream()
            .filter(it -> it.isVertical())
            .forEach(segment -> {
                int x = segment.x();
                int start = segment.startPoint();
                int end = segment.endPoint();

                for (int i = start; i <= end; i++) {
                    diagramData[i][x]++;
                }
            });
    }

    private void gererateHorizontalData(List<Segment> segmentList) {
        segmentList.stream()
            .filter(it -> it.isHorizontal())
            .forEach(segment -> {
                int y = segment.y();
                int start = segment.startPoint();
                int end = segment.endPoint();

                for (int i = start; i <= end; i++) {
                    diagramData[y][i]++;
                }
            });
    }

    public static Diagram create(Segment... segments) {
        return new Diagram(segments);
    }

    public int getValue(int row, int col) {
        return diagramData[row][col];
    }

    public int getResult() {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(diagramData[i][j] >= 2) {
                    result++;
                }
            }
        }
        return result;
    }
}
