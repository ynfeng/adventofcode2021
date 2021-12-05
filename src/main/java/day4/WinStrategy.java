package day4;

import java.util.Optional;

public interface WinStrategy {
    boolean canStop(Board board);

    Optional<Board> getWinBoard(Boards boards);
}
