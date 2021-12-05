package day4;

import java.util.Optional;

public interface WinStrategy {
    Optional<Board> getWinBoard(Boards boards);

    boolean whetherToContinue(Board board, int number);

    int winNumber();
}
