package day2;

public class DefaultSubmarine extends AbstractSubmarine {

    @Override
    public Position forward(int val) {
        setPosition(position().forward(val));
        return position();
    }

    @Override
    public Position down(int val) {
        setPosition(position().down(val));
        return position();
    }

    @Override
    public Position up(int val) {
        if (position().depth() == 0) {
            return position();
        }

        setPosition(position().up(val));
        return position();
    }

}
