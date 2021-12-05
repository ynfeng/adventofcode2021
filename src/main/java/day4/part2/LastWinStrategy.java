package day4.part2;

import com.google.common.collect.Lists;
import day4.Board;
import day4.Boards;
import day4.WinStrategy;
import java.util.List;
import java.util.Optional;

public class LastWinStrategy implements WinStrategy {
    private final List<Board> winners = Lists.newArrayList();
    private int winNumber;

    @Override
    public Optional<Board> getWinBoard(Boards boards) {
        return Optional.ofNullable(winners.get(winners.size() - 1));
    }

    @Override
    public boolean whetherToContinue(Board board, int number) {
        board.call(number);

        if (board.isWin()) {
            winners.add(board);
            winNumber = number;
        }

        return true;
    }

    @Override
    public int winNumber() {
        return winNumber;
    }
}
