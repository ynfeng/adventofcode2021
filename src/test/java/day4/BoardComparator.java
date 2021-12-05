package day4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import utils.Datas;

public class BoardComparator {
    public static void compare(Board board, String resourceName) {
        List<String> lines = Datas.fromResourceAsList(resourceName);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] items = line.split(",");
            for (int j = 0; j < items.length; j++) {
                boolean marked = "1".equals(items[j]) ? true : false;

                assertThat(board.isMarked(i, j)).isEqualTo(marked);
            }
        }
    }
}
