package day1;

public class DiveRateMeter {
    private final SonarSweep sonarSweep;
    private final DepthIncreaseReporter depthIncreaseReport;
    private int diveRate;

    public DiveRateMeter(SonarSweep sonarSweep, DepthIncreaseReporter depthIncreaseReport) {
        this.sonarSweep = sonarSweep;
        this.depthIncreaseReport = depthIncreaseReport;
    }


    public int measureDiveRate() {
        while (true) {
            int depth = sonarSweep.measureDepth();

            if (depth == -1) {
                return diveRate;
            }

            DepthIncreaseResult depthIncreaseResult = depthIncreaseReport.scan(depth);
            System.out.println(String.format("%d (%s)", depth, depthIncreaseResult.toString().toLowerCase()));

            if (depthIncreaseResult == DepthIncreaseResult.INCREASED) {
                diveRate++;
            }
        }
    }
}
