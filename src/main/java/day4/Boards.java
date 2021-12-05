package day4;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Boards {
    private final List<Board> boardList = Lists.newArrayList();
    private final WinStrategy winStrategy;

    public Boards(Board[] boards) {
        this(boards, new FirstWinStrategy());
    }

    public Boards(Board[] boards, WinStrategy winStrategy) {
        Arrays.stream(boards).forEach(boardList::add);
        this.winStrategy = winStrategy;
    }

    public static Boards create(Board[] boards) {
        return new Boards(boards);
    }

    public static Boards create(Board[] boards, WinStrategy winStrategy) {
        return new Boards(boards, winStrategy);
    }


    public Board getBoard(int index) {
        return boardList.get(index);
    }

    public void call(int... numbers) {
        for (int number : numbers) {
            List<Board> remaingBoardList = boardList.stream()
                .filter(it -> !it.isWin())
                .collect(Collectors.toList());

            for (Board board : remaingBoardList) {
                if (!winStrategy.whetherToContinue(board, number)) {
                    return;
                }
            }
        }
    }

    public int score() {
        int boardSum = winStrategy.getWinBoard(this).map(Board::score).orElse(0);

        return boardSum * winStrategy.winNumber();
    }

    public int numOfBoards() {
        return boardList.size();
    }
}
