package day8;

import java.util.Set;
import org.assertj.core.util.Sets;

public class UniqueSignalPattern {
    private final String input;

    public UniqueSignalPattern(String input) {
        this.input = input;
    }

    public static UniqueSignalPattern create(String input) {
        return new UniqueSignalPattern(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UniqueSignalPattern that = (UniqueSignalPattern) o;

        return input.equals(that.input);
    }

    @Override
    public int hashCode() {
        return input.hashCode();
    }

    public int length() {
        return input.length();
    }

    public UniqueSignalPattern exclude(char... chars) {
        StringBuffer sb = new StringBuffer();

        Set<Character> charSet = Sets.newHashSet();
        for (char c : chars) {
            charSet.add(c);
        }

        for (char c : input.toCharArray()) {
            if (charSet.contains(c)) {
                continue;
            }

            sb.append(c);
        }

        return create(sb.toString());
    }

    public UniqueSignalPattern intersect(char... chars) {
        StringBuffer sb = new StringBuffer();

        Set<Character> charSet = Sets.newHashSet();
        for (char c : chars) {
            charSet.add(c);
        }

        for (char c : input.toCharArray()) {
            if (charSet.contains(c)) {
                sb.append(c);
            }
        }

        return create(sb.toString());
    }

    public char charAt(int i) {
        return input.charAt(i);
    }

    public char[] chars() {
        return input.toCharArray();
    }

    public int countIntersect(char... chars) {
        return intersect(chars).chars().length;
    }

    @Override
    public String toString() {
        return "UniqueSignalPattern{" +
            "input='" + input + '\'' +
            '}';
    }
}
