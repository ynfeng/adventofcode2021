package day6.part2;

import java.util.Arrays;

public class LanternfishesV2 {
    private long[] fishes = new long[9];

    private LanternfishesV2(int[] fishData) {
        for (int i = 0; i < fishData.length; i++) {
            fishes[fishData[i]]++;
        }
    }

    public static LanternfishesV2 create(int... fishes) {
        return new LanternfishesV2(fishes);
    }

    public void passDays(int days) {
        for (int i = 0; i < days; i++) {
            long newFishes = fishes[0];

            for (int j = 1; j < 9; j++) {
                fishes[j - 1] = fishes[j];
            }

            fishes[6] = fishes[6] + newFishes;
            fishes[8] = newFishes;
        }
    }

    public long howManyFishes() {
        return Arrays.stream(fishes).sum();
    }
}
