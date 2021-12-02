package day1.part2;


import day1.SonarSweep;
import java.util.List;
import org.assertj.core.util.Lists;

public class WindowSonarSweep implements SonarSweep {
    private static final int WINDOW_SIZE = 3;

    private final List<String> depths = Lists.newArrayList();
    private int index;

    public WindowSonarSweep(List<String> datas) {
        depths.addAll(datas);
    }

    @Override
    public int measureDepth() {
        int sum = 0;

        if (index + WINDOW_SIZE > depths.size()) {
            return -1;
        }

        for (int i = index; i < index + WINDOW_SIZE; i++) {
            int val = Integer.valueOf(depths.get(i));
            sum += val;
        }

        index++;
        return sum;
    }
}
