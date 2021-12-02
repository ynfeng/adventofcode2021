package day2;

public class DefaultSubmarine extends AbstractSubmarine {
    public DefaultSubmarine() {
        super(DefaultPosition.create(0, 0));
    }

    @Override
    public Submarine up(int val) {
        if (position().depth() != 0) {
            setPosition(position().up(val));
        }

        return this;
    }
}
