package day3;

import com.google.common.collect.Lists;
import java.util.List;

public class Numbers {
    private final List<Number> numberList = Lists.newArrayList();

    public Numbers(List<Number> numberList) {
        this.numberList.addAll(numberList);
    }

    public static Numbers create(List<Number> numberList) {
        return new Numbers(numberList);
    }

    public int mostCommonBit(int positoion) {
        int zeroCount = 0;
        int oneCount = 0;

        for (Number number : numberList) {
            int bit = number.bitAt(positoion);

            if (bit == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        return oneCount > zeroCount ? 1 : 0;
    }

    public int numberLength() {
        if (numberList.isEmpty()) {
            return 0;
        }

        return numberList.get(0).length();
    }
}
