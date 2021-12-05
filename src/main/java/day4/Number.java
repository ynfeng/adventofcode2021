package day4;

public class Number {
    private final int value;
    private boolean marked;

    public Number(int value) {
        this.value = value;
    }

    public static Number of(int value) {
        return new Number(value);
    }

    public boolean isMarked() {
        return marked;
    }

    public void mark() {
        marked = true;
    }

    public boolean is(int number) {
        return value == number;
    }

    public int value() {
        return value;
    }
}
