package day2;

public class DefaultSubmarine extends AbstractSubmarine {

    @Override
    public Submarine forward(int val) {
        setPosition(position().forward(val));
        return this;
    }

    @Override
    public Submarine down(int val) {
        setPosition(position().down(val));
        return this;
    }

    @Override
    public Submarine up(int val) {
        if (position().depth() != 0) {
            setPosition(position().up(val));
        }

        return this;
    }

}
