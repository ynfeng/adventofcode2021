package day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoardsTest {

    @Test
    void should_get_board() {
        Boards boards = createBoards();

        assertThat(boards.getBoard(0)).isNotNull();
    }

    @Test
    void should_call_number() {
        Boards boards = createBoards();

        boards.call(7, 4, 9, 5, 11);
        BoardComparator.compare(boards.getBoard(0), "day4/b1");
        BoardComparator.compare(boards.getBoard(1), "day4/b2");
        BoardComparator.compare(boards.getBoard(2), "day4/b3");

        boards.call(17, 23, 2, 0, 14, 21);
        BoardComparator.compare(boards.getBoard(0), "day4/b1-1");
        BoardComparator.compare(boards.getBoard(1), "day4/b2-1");
        BoardComparator.compare(boards.getBoard(2), "day4/b3-1");

        boards.call(24);
        BoardComparator.compare(boards.getBoard(0), "day4/b1-2");
        BoardComparator.compare(boards.getBoard(1), "day4/b2-2");
        BoardComparator.compare(boards.getBoard(2), "day4/b3-2");
    }

    @Test
    void should_get_score() {
        Boards boards = createBoards();
        boards.call(7, 4, 9, 5, 11);
        boards.call(17, 23, 2, 0, 14, 21);
        boards.call(24);

        assertThat(boards.score()).isEqualTo(4512);
    }

    @Test
    void should_get_score_give_all_input() {
        Boards boards = createBoards();

        boards.call(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1);

        assertThat(boards.score()).isEqualTo(4512);
    }

    @Test
    void should_stop_when_one_board_win() {
        Boards boards = createBoards();

        boards.call(22, 13, 17, 11, 0, 8, 2);

        Board board1 = boards.getBoard(0);
        Board board2 = boards.getBoard(1);
        Board board3 = boards.getBoard(2);

        BoardComparator.compare(board1, "day4/b1-3");
        BoardComparator.compare(board2, "day4/b2-3");
        BoardComparator.compare(board3, "day4/b3-3");
    }

    static Boards createBoards() {
        return Boards.create(
            new Board[] {
                Board.create(
                    new int[][] {
                        {22, 13, 17, 11, 0},
                        {8, 2, 23, 4, 24},
                        {21, 9, 14, 16, 7},
                        {6, 10, 3, 18, 5},
                        {1, 12, 20, 15, 19}
                    }),
                Board.create(
                    new int[][] {
                        {3, 15, 0, 2, 22},
                        {9, 18, 13, 17, 5},
                        {19, 8, 7, 25, 23},
                        {20, 11, 10, 24, 4},
                        {14, 21, 16, 12, 6}
                    }),
                Board.create(
                    new int[][] {
                        {14, 21, 17, 24, 4},
                        {10, 16, 15, 9, 19},
                        {18, 8, 23, 26, 20},
                        {22, 11, 13, 6, 5},
                        {2, 0, 12, 3, 7}
                    })
            }
        );
    }
}
