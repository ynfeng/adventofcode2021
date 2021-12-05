package day4;

import java.util.Optional;

public class FirstWinStrategy implements WinStrategy {
    private int winNumber;
    private Board winner;

    @Override
    public Optional<Board> getWinBoard(Boards boards) {
        return Optional.ofNullable(winner);
    }

    @Override
    public boolean whetherToContinue(Board board, int number) {
        board.call(number);

        if (board.isWin()) {
            winNumber = number;
            winner = board;
            return false;
        }

        return true;
    }

    @Override
    public int winNumber() {
        return winNumber;
    }


}
