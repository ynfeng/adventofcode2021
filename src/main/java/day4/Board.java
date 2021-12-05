package day4;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Board {
    private final Number[][] numbers = new Number[5][5];

    public Board(int[][] datas) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = Number.of(datas[i][j]);
            }
        }
    }

    public static Board create(int[][] datas) {
        return new Board(datas);
    }

    public boolean call(int aNumber) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Number number = numbers[i][j];
                if (number.is(aNumber)) {
                    number.mark();

                    if (isWin()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean call(int... numbers) {
        for (int number : numbers) {
            if (call(number)) {
                return true;
            }
        }

        return false;
    }

    public boolean isMarked(int row, int col) {
        return numbers[row][col].isMarked();
    }

    public boolean isWin() {
        return anyRowAllMarked() || anyColumnAllMarked();
    }

    private boolean anyRowAllMarked() {
        return checkIsMarked((row, col) -> numbers[row][col].isMarked());
    }

    private boolean anyColumnAllMarked() {
        return checkIsMarked((row, col) -> numbers[col][row].isMarked());
    }

    private static boolean checkIsMarked(BiPredicate<Integer, Integer> checker) {
        for (int i = 0; i < 5; i++) {

            int numOfMarked = 0;
            for (int j = 0; j < 5; j++) {
                if (Boolean.TRUE.equals(checker.test(i, j))) {
                    numOfMarked++;
                }
            }

            if (numOfMarked == 5) {
                return true;
            }
        }

        return false;
    }

    public int score() {
        return Arrays.stream(numbers)
            .flatMap(it -> Arrays.stream(it))
            .filter(it -> !it.isMarked())
            .mapToInt(Number::value)
            .sum();
    }
}
