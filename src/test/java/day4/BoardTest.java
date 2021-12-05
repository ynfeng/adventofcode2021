package day4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void should_create_board() {
        Board board = createBoard();

        assertThat(board).isNotNull();
    }

    @Test
    void should_call_number() {
        Board board = createBoard();

        board.call(22);
        board.call(9);

        assertThat(board.isMarked(0, 0)).isTrue();
        assertThat(board.isMarked(2, 1)).isTrue();
    }

    @Test
    void should_win_when_one_row_makred() {
        Board board = createBoard();

        board.call(6, 10, 3, 18, 5);

        assertThat(board.isWin()).isTrue();
    }

    @Test
    void should_not_win_when_no_row_makred() {
        Board board = createBoard();

        board.call(6, 11, 3, 18, 5);

        assertThat(board.isWin()).isFalse();
    }

    @Test
    void should_win_when_one_column_makred() {
        Board board = createBoard();

        board.call(11, 4, 16, 18, 15);

        assertThat(board.isWin()).isTrue();
    }

    @Test
    void should_not_win_when_no_column_makred() {
        Board board = createBoard();

        board.call(11, 41, 16, 18, 15);

        assertThat(board.isWin()).isFalse();
    }

    @Test
    void should_not_mark_when_already_win() {
        Board board = createBoard();

        board.call(22, 13, 17, 11, 0, 8, 2);

        assertThat(board.isMarked(0, 0)).isTrue();
        assertThat(board.isMarked(0, 1)).isTrue();
        assertThat(board.isMarked(0, 2)).isTrue();
        assertThat(board.isMarked(0, 3)).isTrue();
        assertThat(board.isMarked(0, 4)).isTrue();
        assertThat(board.isMarked(1, 0)).isFalse();
        assertThat(board.isMarked(1, 1)).isFalse();
    }

    @Test
    void should_get_score() {
        Board board = createBoard();
        board.call(22, 13, 17, 11, 0, 8, 2);

        assertThat(board.score()).isEqualTo(237);
    }

    private static Board createBoard() {
        return Board.create(
            new int[][] {
                {22, 13, 17, 11, 0},
                {8, 2, 23, 4, 24},
                {21, 9, 14, 16, 7},
                {6, 10, 3, 18, 5},
                {1, 12, 20, 15, 19}
            }
        );
    }
}
