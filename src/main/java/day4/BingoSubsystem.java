package day4;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

public class BingoSubsystem {
    private final int[] inputs;
    private final Boards boards;

    public BingoSubsystem(List<String> datas, WinStrategy winStrategy) {
        inputs = Arrays.stream(datas.get(0).split(","))
            .mapToInt(Integer::valueOf)
            .toArray();

        boards = generateBoards(datas, winStrategy);
    }

    public BingoSubsystem(List<String> datas) {
        this(datas, new FirstWinStrategy());
    }

    private Boards generateBoards(List<String> datas, WinStrategy winStrategy) {
        List<Board> boards = Lists.newArrayList();

        int[][] boardData = new int[5][5];
        int rowNum = 0;

        for (int i = 2; i < datas.size(); i++) {
            String line = datas.get(i);

            if (line.isEmpty()) {
                Board board = Board.create(boardData);
                boards.add(board);

                rowNum = 0;
                boardData = new int[5][5];
                continue;
            }

            int[] cols = Arrays.stream(line.split(" "))
                .filter(it -> !it.isEmpty())
                .mapToInt(Integer::valueOf)
                .toArray();

            boardData[rowNum++] = cols;
        }

        return Boards.create(boards.toArray(new Board[] {}), winStrategy);
    }

    public int[] inputs() {
        return inputs.clone();
    }

    public int numOfBoards() {
        return boards.numOfBoards();
    }

    public int play() {
        boards.call(inputs());

        return boards.score();
    }
}
