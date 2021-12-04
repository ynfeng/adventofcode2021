package day3;

public class DiagnosticReport {
    private final Numbers numbers;

    public DiagnosticReport(Numbers numbers) {
        this.numbers = numbers;
    }

    public int gammaRate() {
        int result = 0;

        for (int i = numbers.eachNumberLength() - 1; i >= 0; i--) {
            int bit = mostCommon(numbers, i);

            result <<= 1;
            result |= bit;
        }

        return result;
    }

    public int epsilonRate() {
        int gammaRate = gammaRate();
        int mask = 1;

        for (int i = 0; i < numbers.eachNumberLength() - 1; i++) {
            mask <<= 1;
            mask |= 1;
        }

        return ~gammaRate & mask;
    }

    public int mostCommon(Numbers numbers, int position) {
        int numberOfZero = numbers.numOfZeroDigitInBit(position);
        int numberOfOne = numbers.numOfOneDigitInBit(position);

        return numberOfOne > numberOfZero ? 1 : 0;
    }

    public int getResult() {
        return gammaRate() * epsilonRate();
    }
}
