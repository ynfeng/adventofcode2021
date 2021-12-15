package day8;

import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Digit {
    private final String input;
    private final char[] configurations = new char[7];

    public Digit(String input) {
        this.input = input;

        analysis();
    }

    private void analysis() {
        String uniqueSignalPattern = uniqueSignalPattern();
        UniqueSignalPatterns uniqueSignalPatterns = UniqueSignalPatterns.create(uniqueSignalPattern);

        analysisByOne(uniqueSignalPatterns);
        analysisBySeven(uniqueSignalPatterns);
        analysisByFour(uniqueSignalPatterns);
        analysisByThree(uniqueSignalPatterns);
        analysisByEight(uniqueSignalPatterns);
        analysisBySix(uniqueSignalPatterns);
    }

    private void analysisByThree(UniqueSignalPatterns uniqueSignalPatterns) {
        char[] configured = allConfigured();

        UniqueSignalPattern patternOfSeven = uniqueSignalPatterns.getByLength(3).get(0);
        List<UniqueSignalPattern> fiveLengthPatterns = uniqueSignalPatterns.getByLength(5);
        UniqueSignalPattern patternOfThree = fiveLengthPatterns.stream()
            .filter(it -> patternOfSeven.countIntersect(it.chars()) == 3)
            .findAny()
            .orElse(null);

        UniqueSignalPattern exclude = patternOfThree.exclude(configured);
        configurations[4] = exclude.charAt(0);
    }

    private void analysisBySix(UniqueSignalPatterns uniqueSignalPatterns) {
        UniqueSignalPattern parttenOfOne = uniqueSignalPatterns.getByLength(2).get(0);
        UniqueSignalPattern patternOfSeven = uniqueSignalPatterns.getByLength(3).get(0);
        List<UniqueSignalPattern> fiveLengthPatterns = uniqueSignalPatterns.getByLength(6);

        UniqueSignalPattern patternOfSix = fiveLengthPatterns.stream()
            .filter(it -> patternOfSeven.countIntersect(it.chars()) == 2)
            .findAny()
            .orElse(null);

        UniqueSignalPattern intersect = patternOfSix.intersect(parttenOfOne.chars());
        configurations[3] = intersect.charAt(0);
        configurations[2] = parttenOfOne.exclude(intersect.chars()).charAt(0);
    }

    private void analysisByEight(UniqueSignalPatterns uniqueSignalPatterns) {
        UniqueSignalPattern patternForEight = uniqueSignalPatterns.getByLength(7).get(0);

        UniqueSignalPattern exclude = patternForEight.exclude(allConfigured());
        configurations[5] = exclude.charAt(0);
    }

    public static Digit create(String input) {
        return new Digit(input);
    }

    public int countUniqueNumberOfSegments() {
        String[] outputItems = getOutputItems();

        long count = Arrays.stream(outputItems).filter(this::isUniqueNumberOfSegments).count();

        return (int) count;
    }

    private String[] getOutputItems() {
        String output = getOutput();
        String[] outputItems = output.split(" ");
        return outputItems;
    }

    private boolean isUniqueNumberOfSegments(String input) {
        int length = input.length();

        return length == 2 || length == 4 || length == 3 || length == 7;
    }

    private String getOutput() {
        return input.split("\\|")[1].trim();
    }

    public String configuration() {
        return new String(configurations);
    }

    private void analysisByFour(UniqueSignalPatterns uniqueSignalPatterns) {
        UniqueSignalPattern patternOfSeven = uniqueSignalPatterns.getByLength(3).get(0);
        List<UniqueSignalPattern> fiveLengthPatterns = uniqueSignalPatterns.getByLength(5);
        UniqueSignalPattern patternOfThree = fiveLengthPatterns.stream()
            .filter(it -> patternOfSeven.countIntersect(it.chars()) == 3)
            .findAny()
            .orElse(null);
        UniqueSignalPattern patternOfFour = uniqueSignalPatterns.getByLength(4).get(0);

        UniqueSignalPattern exclude = patternOfFour.exclude(patternOfThree.chars());
        configurations[0] = exclude.charAt(0);

        char[] configured = allConfigured();
        exclude = patternOfFour.exclude(configured);
        configurations[6] = exclude.charAt(0);
    }

    private char[] allConfigured() {
        StringBuffer sb = new StringBuffer();

        for (char c : configurations) {
            if (c != 0) {
                sb.append(c);
            }
        }

        return sb.toString().toCharArray();
    }

    private void analysisBySeven(UniqueSignalPatterns uniqueSignalPatterns) {
        UniqueSignalPattern parttenOfOne = uniqueSignalPatterns.getByLength(2).get(0);
        UniqueSignalPattern parttenOfSeven = uniqueSignalPatterns.getByLength(3).get(0);
        UniqueSignalPattern exclude = parttenOfSeven.exclude(parttenOfOne.chars());
        configurations[1] = exclude.charAt(0);
    }

    private UniqueSignalPattern analysisByOne(UniqueSignalPatterns uniqueSignalPatterns) {
        UniqueSignalPattern parttenOfOne = uniqueSignalPatterns.getByLength(2).get(0);

        configurations[2] = parttenOfOne.charAt(0);
        configurations[3] = parttenOfOne.charAt(1);

        return parttenOfOne;
    }

    private String uniqueSignalPattern() {
        return input.split("\\|")[0].trim();
    }

    public int number() {
        Map<String, Integer> numberMap = getNumberMap();

        char[] outputChars;
        int result = 0;
        for (String output : getOutputItems()) {
            outputChars = output.toCharArray();
            Arrays.sort(outputChars);

            String key = new String(outputChars);
            Integer number = numberMap.get(key);
            if (number == null) {
                System.out.println(key);
            }
            result *= 10;
            result += number;
        }

        return result;
    }

    private Map<String, Integer> getNumberMap() {
        Map<String, Integer> numberMap = Maps.newHashMap();

        numberMap.put(
            getConfiguration(0, 1, 2, 3, 4, 5),
            0);
        numberMap.put(
            getConfiguration(2, 3),
            1);
        numberMap.put(
            getConfiguration(1, 2, 6, 5, 4),
            2);
        numberMap.put(
            getConfiguration(1, 6, 4, 2, 3),
            3);
        numberMap.put(
            getConfiguration(0, 6, 2, 3),
            4);
        numberMap.put(
            getConfiguration(1, 0, 6, 3, 4),
            5);
        numberMap.put(
            getConfiguration(1, 0, 6, 5, 3, 4),
            6);
        numberMap.put(
            getConfiguration(1, 2, 3),
            7);
        numberMap.put(
            getConfiguration(0, 1, 2, 3, 4, 5, 6),
            8);
        numberMap.put(
            getConfiguration(0, 1, 2, 3, 4, 6),
            9);

        return numberMap;
    }

    private String getConfiguration(int... positions) {
        char[] result = new char[positions.length];

        int i = 0;
        for (int position : positions) {
            result[i++] = configurations[position];
        }

        Arrays.sort(result);
        return new String(result);
    }
}
