package day8;

import java.util.Arrays;

public class Digit {
    private final String input;

    public Digit(String input) {
        this.input = input;
    }

    public static Digit create(String input) {
        return new Digit(input);
    }

    public int countUniqueNumberOfSegments() {
        String output = getOutput();
        String[] outputItems = output.split(" ");

        long count = Arrays.stream(outputItems).filter(this::isUniqueNumberOfSegments).count();

        return (int) count;
    }

    private boolean isUniqueNumberOfSegments(String input) {
        int length = input.length();

        return length == 2 || length == 4 || length == 3 || length == 7;
    }

    private String getOutput() {
        return input.split("\\|")[1].trim();
    }
}
