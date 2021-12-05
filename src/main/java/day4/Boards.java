package day4;

import java.util.Arrays;

public class Boards {
    private final Board[] boards;
    private int lastNumber;

    public Boards(Board[] boards) {
        this.boards = boards;
    }

    public static Boards create(Board[] boards) {
        return new Boards(boards);
    }

    public Board getBoard(int index) {
        return boards[index];
    }

    public void call(int... numbers) {
        for (int number : numbers) {
            for (Board board : boards) {
                if (board.call(number)) {
                    lastNumber = number;
                    return;
                }
            }
        }
    }

    public int score() {
        int boardSum = Arrays.stream(boards)
            .filter(Board::isWin)
            .mapToInt(Board::score)
            .sum();

        return boardSum * lastNumber;
    }

    public int numOfBoards() {
        return boards.length;
    }
}
