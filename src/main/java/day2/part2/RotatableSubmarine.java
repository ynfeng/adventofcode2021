package day2.part2;

import day2.AbstractSubmarine;
import day2.Submarine;

public class RotatableSubmarine extends AbstractSubmarine {
    public RotatableSubmarine() {
        super(RotatablePosition.create(0, 0, 0));
    }

    public int aim() {
        return ((RotatablePosition) position()).aim();
    }

    @Override
    public Submarine up(int val) {
        if (aim() != 0) {
            setPosition(position().up(val));
        }

        return this;
    }
}
