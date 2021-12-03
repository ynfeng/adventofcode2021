package day3;

public class DiagnosticReport {
    private final Numbers numbers;

    public DiagnosticReport(Numbers numbers) {
        this.numbers = numbers;
    }

    public int getGammaRate() {
        int result = 0;

        for (int i = numbers.numberLength() - 1; i >= 0; i--) {
            int bit = numbers.mostCommonBit(i);

            result <<= 1;
            result |= bit;
        }

        return result;
    }

    public int epsilonRate() {
        int gammaRate = getGammaRate();
        int mask = 1;

        for (int i = 0; i < numbers.numberLength() - 1; i++) {
            mask <<= 1;
            mask |= 1;
        }

        return ~gammaRate & mask;
    }

    public int getResult() {
        return getGammaRate() * epsilonRate();
    }
}
