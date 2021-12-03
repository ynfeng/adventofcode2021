package day3.part2;

import day3.Number;

public class DiagnosticReportV2 {
    private final NumbersV2 numbers;

    public DiagnosticReportV2(NumbersV2 numbers) {
        this.numbers = numbers;
    }

    public int getOxygenGeneratorRating() {
        NumbersV2 numbers = this.numbers.copy();

        for (int i = numbers.numberLength() - 1; i >= 0; i--) {
            final int bitIndex = i;
            int bit = forOxygenGeneratorRating(numbers, bitIndex);
            numbers = numbers.filter(it -> it.bitAt(bitIndex) == bit);

            if (numbers.howManyNumbers() == 1) {
                break;
            }
        }

        Number number = numbers.get(0);

        return number.toInt();
    }

    private int forOxygenGeneratorRating(NumbersV2 numbers, int bitIndex) {
        int oneCount = numbers.countOneAtBitPosition(bitIndex);
        int zeroCount = numbers.countZeroAtBitPosition(bitIndex);

        if (oneCount > zeroCount) {
            return 1;
        }

        if (oneCount == zeroCount) {
            return 1;
        }

        return 0;
    }

    public int getCo2ScrubberRating() {
        NumbersV2 numbers = this.numbers.copy();

        for (int i = numbers.numberLength() - 1; i >= 0; i--) {
            final int bitIndex = i;
            int bit = forCo2ScrubberRating(numbers, bitIndex);
            numbers = numbers.filter(it -> it.bitAt(bitIndex) == bit);

            if (numbers.howManyNumbers() == 1) {
                break;
            }
        }

        Number number = numbers.get(0);

        return number.toInt();
    }

    private int forCo2ScrubberRating(NumbersV2 numbers, int bitIndex) {
        int oneCount = numbers.countOneAtBitPosition(bitIndex);
        int zeroCount = numbers.countZeroAtBitPosition(bitIndex);

        if (oneCount < zeroCount) {
            return 1;
        }

        if (oneCount == zeroCount) {
            return 0;
        }

        return 0;
    }

    public int getResult() {
        return getCo2ScrubberRating() * getOxygenGeneratorRating();
    }
}
