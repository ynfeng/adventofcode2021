package day6;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Lanternfishes {
    private final Queue<Lanternfish> allFish = new ConcurrentLinkedQueue<Lanternfish>();

    public Lanternfishes(Lanternfish[] fishes) {
        Arrays.stream(fishes).forEach(allFish::add);
    }

    public static Lanternfishes create(Lanternfish... fishes) {
        return new Lanternfishes(fishes);
    }

    public static Lanternfishes create(String input) {
        Lanternfish fishes[] = Arrays.stream(input.split(","))
            .mapToInt(Integer::valueOf)
            .mapToObj(Lanternfish::create)
            .collect(toList())
            .toArray(new Lanternfish[] {});

        return new Lanternfishes(fishes);
    }

    public void oneDayPassed() {
        for (Lanternfish fish : allFish) {
            if (fish.oneDayPassed()) {
                allFish.offer(Lanternfish.create(9));
            }
        }
    }

    @Override
    public String toString() {
        return allFish.stream()
            .map(Lanternfish::spawnInDays)
            .map(it -> String.valueOf(it))
            .collect(Collectors.joining(","));
    }

    public void passDays(int days) {
        for (int i = 0; i < days; i++) {
            oneDayPassed();
        }
    }

    public int howManyFish() {
        return allFish.size();
    }
}
