package day3.part2;

import day3.Number;
import java.util.function.BiFunction;

public class DiagnosticReportV2 {
    private final NumbersV2 numbers;

    public DiagnosticReportV2(NumbersV2 numbers) {
        this.numbers = numbers;
    }

    public int oxygenGeneratorRating() {
        return findNumber(DiagnosticReportV2::mostCommon);
    }

    public int co2ScrubberRating() {
        return findNumber(DiagnosticReportV2::leastCommon);
    }

    private int findNumber(BiFunction<NumbersV2, Integer, Integer> bitCriteriaProvider) {
        NumbersV2 theNumbers = numbers.copy();

        for (int i = theNumbers.eachNumberLength() - 1; i >= 0; i--) {
            final int bitIndex = i;
            int bitCriteria = bitCriteriaProvider.apply(theNumbers, bitIndex);
            theNumbers = theNumbers.filterByBitCriteria(it -> it.bitAt(bitIndex) == bitCriteria);

            if (theNumbers.howManyNumbers() == 1) {
                break;
            }
        }

        Number number = theNumbers.get(0);

        return number.toInt();
    }

    private static int mostCommon(NumbersV2 numbers, int bitIndex) {
        int numberOfOne = numbers.numOfOneDigitInBit(bitIndex);
        int numberOfZero = numbers.numOfZeroDigitInBit(bitIndex);

        if (numberOfOne > numberOfZero) {
            return 1;
        }

        if (numberOfOne == numberOfZero) {
            return 1;
        }

        return 0;
    }

    private static int leastCommon(NumbersV2 numbers, int bitIndex) {
        int numberOfOne = numbers.numOfOneDigitInBit(bitIndex);
        int numberOfZero = numbers.numOfZeroDigitInBit(bitIndex);

        if (numberOfOne < numberOfZero) {
            return 1;
        }

        return 0;
    }

    public int getResult() {
        return co2ScrubberRating() * oxygenGeneratorRating();
    }
}
