package day10;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chunks {
    private final List<ChunkChar> chunkChars;

    private Chunks(String line) {
        Stream<Character> charStream = IntStream.range(0, line.length()).mapToObj(i -> line.charAt(i));

        chunkChars = charStream.map(ChunkChar::of).collect(Collectors.toList());
    }

    public static Chunks create(String line) {
        return new Chunks(line);
    }

    public ChunkChar missed() {
        Stack<ChunkChar> stack = new Stack<>();

        for (int i = 0; i < chunkChars.size(); i++) {
            ChunkChar chunkChar = chunkChars.get(i);

            if (chunkChar.isOpen()) {
                stack.push(chunkChar);
                continue;
            }

            ChunkChar openChar = stack.peek();

            if (openChar.isPair(chunkChar.value())) {
                stack.pop();
            } else {
                return chunkChar;
            }
        }

        return ChunkChar.of(' ');
    }
}
