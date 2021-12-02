package day1;

public class DepthIncreaseReporter {
    private int previousMeasurment = -1;

    public DepthIncreaseResult scan(int depth) {
        int tmp = previousMeasurment;
        previousMeasurment = depth;

        if (tmp == -1) {
            return DepthIncreaseResult.NONE;
        }

        if (tmp < depth) {
            return DepthIncreaseResult.INCREASED;
        }

        return DepthIncreaseResult.DECREASED;
    }
}
