package day10;

import com.google.common.collect.ImmutableMap;

public class ChunkChar {
    private final char ch;
    private static final ImmutableMap<Character, Character> PAIRS = ImmutableMap.<Character, Character>builder()
        .put('(', ')')
        .put('[', ']')
        .put('{', '}')
        .put('<', '>')
        .build();

    private static final ImmutableMap<Character, Integer> CORRUPTED_POINTS = ImmutableMap.<Character, Integer>builder()
        .put(')', 3)
        .put(']', 57)
        .put('}', 1197)
        .put('>', 25137)
        .build();

    private static final ImmutableMap<Character, Integer> COMPLETE_POINTS = ImmutableMap.<Character, Integer>builder()
        .put(')', 1)
        .put(']', 2)
        .put('}', 3)
        .put('>', 4)
        .build();

    public ChunkChar(char ch) {
        this.ch = ch;
    }

    public static ChunkChar EMPTY = of(' ');

    public static ChunkChar of(char open) {
        return new ChunkChar(open);
    }

    public boolean isPair(char close) {
        return PAIRS.getOrDefault(ch, ' ') == close;
    }

    public char value() {
        return ch;
    }

    public boolean isOpen() {
        return PAIRS.get(ch) != null;
    }

    public char closeChar() {
        return PAIRS.getOrDefault(ch, ' ').charValue();
    }

    public int corruptedPoints() {
        return CORRUPTED_POINTS.getOrDefault(ch, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChunkChar chunkChar = (ChunkChar) o;

        return ch == chunkChar.ch;
    }

    @Override
    public int hashCode() {
        return ch;
    }

    public boolean isEmpty() {
        return ch == ' ';
    }

    @Override
    public String toString() {
        return "ChunkChar{" +
            "ch=" + ch +
            '}';
    }

    public int completePoints() {
        return COMPLETE_POINTS.getOrDefault(ch, 0);
    }
}
