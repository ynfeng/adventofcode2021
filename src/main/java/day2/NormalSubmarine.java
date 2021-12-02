package day2;

public class NormalSubmarine extends AbstractSubmarine {
    public NormalSubmarine() {
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
