package day6;

public class Lanternfish {
    private int spawnInDays;

    private Lanternfish(int spawnInDays) {
        this.spawnInDays = spawnInDays;
    }

    public static Lanternfish create(int spawnInDays) {
        return new Lanternfish(spawnInDays);
    }

    public boolean oneDayPassed() {
        if (spawnInDays() == 0) {
            spawnInDays = 6;
            return true;
        } else {
            spawnInDays--;
            return false;
        }
    }

    public int spawnInDays() {
        return spawnInDays;
    }
}
