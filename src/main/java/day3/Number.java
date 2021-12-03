package day3;

public class Number {
    private final char[] numChars;

    private Number(String numString) {
        numChars = numString.toCharArray();
    }

    public static Number of(String numString) {
        return new Number(numString);
    }

    public int bitAt(int index) {
        char numChar = numChars[numChars.length - index - 1];

        return Character.getNumericValue(numChar);
    }

    public int length() {
        return numChars.length;
    }
}
