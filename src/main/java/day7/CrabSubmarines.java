package day7;

public class CrabSubmarines {
    private final int[] positions;

    public CrabSubmarines(int... positions) {
        this.positions = positions;
    }

    public static CrabSubmarines create(int... positions) {
        return new CrabSubmarines(positions);
    }

    public int leastFuelSpend() {
        int minFuelCost = Integer.MAX_VALUE;

        for (int i = 0; i < positions.length; i++) {
            minFuelCost = Math.min(toPosition(positions[i]), minFuelCost);
        }

        return minFuelCost;
    }

    public int toPosition(int position) {
        int totalFuelCost = 0;

        for (int i = 0; i < positions.length; i++) {
            int fuelCost = getFuelCost(position, positions[i]);
            totalFuelCost += fuelCost;
        }

        return totalFuelCost;
    }

    protected int getFuelCost(int from, int to) {
        return Math.abs(from - to);
    }
}
