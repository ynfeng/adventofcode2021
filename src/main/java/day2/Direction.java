package day2;

import java.util.Arrays;

public enum Direction {
    FORWARD {
        @Override
        void execute(Submarine submarine, int distance) {
            submarine.forward(distance);
        }
    }, UP {
        @Override
        void execute(Submarine submarine, int distance) {
            submarine.up(distance);
        }
    }, DOWN {
        @Override
        void execute(Submarine submarine, int distance) {
            submarine.down(distance);
        }
    };

    public static Direction formString(String str) {
        return Arrays.stream(values())
            .filter(it -> it.toString().toLowerCase().equals(str))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("wrong direction."));
    }

    abstract void execute(Submarine submarine, int distance);
}
