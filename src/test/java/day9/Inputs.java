package day9;

import java.util.List;
import utils.Datas;

public class Inputs {
    protected int[][] getInputs() {
        List<String> lines = Datas.fromResourceAsList("day9/data");
        int[][] input = new int[lines.size()][lines.get(0).length()];

        for (int i = 0; i < input.length; i++) {
            String line = lines.get(i);

            for (int j = 0; j < line.length(); j++) {
                char[] chars = line.toCharArray();
                input[i][j] = Character.getNumericValue(chars[j]);
            }
        }
        return input;
    }
}
