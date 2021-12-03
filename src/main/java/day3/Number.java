package day3;

import java.util.Arrays;

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

    public int toInt() {
        int result = 0;

        for (int i = length() - 1; i >= 0; i--) {
            result <<= 1;
            result |= bitAt(i);
        }

        return result;
    }

    public int length() {
        return numChars.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number number = (Number) o;

        return Arrays.equals(numChars, number.numChars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numChars);
    }

    @Override
    public String toString() {
        return "Number{" +
            "numChars=" + Arrays.toString(numChars) +
            '}';
    }
}
