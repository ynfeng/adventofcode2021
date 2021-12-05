package day4;

import java.util.Optional;

public class Boards {
    private final Board[] boards;
    private int lastNumber;
    private final WinStrategy winStrategy;

    public Boards(Board[] boards) {
        this(boards, new FirstWinStrategy());
    }

    public Boards(Board[] boards, WinStrategy winStrategy) {
        this.boards = boards;
        this.winStrategy = winStrategy;
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
                board.call(number);

                if (winStrategy.canStop(board)) {
                    lastNumber = number;
                    return;
                }
            }
        }
    }

    public int score() {
        int boardSum = winStrategy.getWinBoard(this).map(Board::score).orElse(0);

        return boardSum * lastNumber;
    }

    public int numOfBoards() {
        return boards.length;
    }

    public Optional<Board> getFirstWinBoard() {
        for (Board board : boards) {
            if (board.isWin()) {
                return Optional.of(board);
            }
        }

        return Optional.empty();
    }
}
