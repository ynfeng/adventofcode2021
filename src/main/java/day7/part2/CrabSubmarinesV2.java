package day7.part2;

import day7.CrabSubmarines;

public class CrabSubmarinesV2 extends CrabSubmarines {
    private CrabSubmarinesV2(int[] positions) {
        super(positions);
    }

    public static CrabSubmarinesV2 create(int... positions) {
        return new CrabSubmarinesV2(positions);

    }

    @Override
    protected int getFuelCost(int from, int to) {
        int steps = super.getFuelCost(from, to);

        int totalCost = 0;
        int extraCost = 1;

        for (int i = 1; i < steps + 1; i++) {
            totalCost += extraCost;
            extraCost++;
        }

        return totalCost;
    }
}
