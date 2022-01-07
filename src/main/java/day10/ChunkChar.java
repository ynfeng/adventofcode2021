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

    private static final ImmutableMap<Character, Integer> POINTS = ImmutableMap.<Character, Integer>builder()
        .put(')', 3)
        .put(']', 57)
        .put('}', 1197)
        .put('>', 25137)
        .build();

    public ChunkChar(char ch) {
        this.ch = ch;
    }

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

    public int points() {
        return POINTS.getOrDefault(ch, 0);
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
}
