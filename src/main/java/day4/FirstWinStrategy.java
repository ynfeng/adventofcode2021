package day4;

import java.util.Optional;

public class FirstWinStrategy implements WinStrategy {
    @Override
    public boolean canStop(Board board) {
        return board.isWin();
    }

    @Override
    public Optional<Board> getWinBoard(Boards boards) {
        return boards.getFirstWinBoard();
    }
}
