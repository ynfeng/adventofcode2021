package day1;


import java.util.List;
import org.assertj.core.util.Lists;

public class DefaultSonarSweep implements SonarSweep {
    private final List<String> depths = Lists.newArrayList();
    private int index;

    public DefaultSonarSweep(List<String> datas) {
        depths.addAll(datas);
    }

    @Override
    public int measureDepth() {
        if (index == depths.size()) {
            return -1;
        }

        return Integer.valueOf(depths.get(index++));
    }
}
