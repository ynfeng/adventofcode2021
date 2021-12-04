package day3;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Number> numberList = Lists.newArrayList();

    public Numbers(List<Number> numberList) {
        this.numberList.addAll(numberList);
    }

    public static Numbers create(List<Number> numberList) {
        return new Numbers(numberList);
    }

    public int numOfOneDigitInBit(int position) {
        int result = 0;

        for (Number number : numberList) {
            int bit = number.bitAt(position);

            if (bit == 1) {
                result++;
            }
        }

        return result;
    }

    public int numOfZeroDigitInBit(int position) {
        return howManyNumbers() - numOfOneDigitInBit(position);
    }

    public int numberLength() {
        if (numberList.isEmpty()) {
            return 0;
        }

        return numberList.get(0).length();
    }

    protected List<Number> numberList() {
        return Collections.unmodifiableList(numberList);
    }

    @Override
    public String toString() {
        return "Numbers{" +
            "numberList=" + numberList +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Numbers numbers = (Numbers) o;

        return numberList.equals(numbers.numberList);
    }

    @Override
    public int hashCode() {
        return numberList.hashCode();
    }

    public int howManyNumbers() {
        return numberList.size();
    }

    public Number get(int index) {
        return numberList.get(index);
    }
}
