package day4;

import static org.assertj.core.api.Assertions.assertThat;

import day4.part2.LastWinStrategy;
import org.junit.jupiter.api.Test;
import utils.Datas;

class BingoSubsystemTest {

    @Test
    void should_get_inputs() {
        BingoSubsystem bingoSubsystem = new BingoSubsystem(Datas.fromResourceAsList("day4/data"));

        assertThat(bingoSubsystem.inputs()).isEqualTo(new int[] {
            90, 4, 2, 96, 46, 1, 62, 97, 3, 52, 7, 35, 50, 28, 31, 37, 74, 26, 59, 53, 82, 47, 83, 80, 19, 40, 68, 95, 34, 55, 54, 73, 12, 78, 30, 63, 57, 93, 72, 77, 56, 91, 23, 67, 64, 79, 85, 84, 76, 10, 58, 0, 29, 13, 94, 20, 32, 25, 11, 38, 89, 21, 98, 92, 42, 27, 14, 99, 24, 75, 86, 51, 22, 48, 9, 33, 49, 18, 70, 8, 87, 61, 39, 16, 66, 71, 5, 69, 15, 43, 88, 45, 6, 81, 60, 36, 44, 17, 41, 65
        });
    }

    @Test
    void should_generate_boards() {
        BingoSubsystem bingoSubsystem = new BingoSubsystem(Datas.fromResourceAsList("day4/data"));

        assertThat(bingoSubsystem.numOfBoards()).isEqualTo(99);
    }


    @Test
    void should_get_answer() {
        BingoSubsystem bingoSubsystem = new BingoSubsystem(Datas.fromResourceAsList("day4/data"));

        int score = bingoSubsystem.play();

        assertThat(score).isEqualTo(8136);
    }

    @Test
    void should_get_part2_answer() {
        BingoSubsystem bingoSubsystem = new BingoSubsystem(
            Datas.fromResourceAsList("day4/data"),
            new LastWinStrategy());

        int score = bingoSubsystem.play();

        assertThat(score).isEqualTo(12738);
    }
}
