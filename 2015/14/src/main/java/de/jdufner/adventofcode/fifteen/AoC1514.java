package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1514 {

    private static final Pattern PATTERN = Pattern.compile("\\w+ can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");

    private final List<Reindeer> reindeers = new ArrayList<>();

    int calculateDistance(int speed, int perseverance, int rest, int time) {
        int integer = time / (perseverance + rest);
        int remainder = time % (perseverance + rest);
        if (remainder > perseverance) {
            return (integer + 1) * perseverance * speed;
        } else {
            return integer * perseverance * speed + remainder * speed;
        }
    }

    int maxDistance(List<Reindeer> reindeerList, int time) {
        int maxDistance = 0;
        for (Reindeer reindeer : reindeerList) {
            int distance = calculateDistance(reindeer.getSpeed(), reindeer.getPerseverance(), reindeer.getRest(), time);
            System.out.println(reindeer.getSpeed() + " " + reindeer.getPerseverance() + " " + reindeer.getRest() + " -> " + distance);
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    int maxDistanceFromFile(String filename, int time) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        return maxDistance(reindeers, time);
    }

    private void parseString(String line) {
        Matcher matcher = PATTERN.matcher(line);
        Reindeer reindeer = null;
        if (matcher.matches()) {
            reindeer = new Reindeer(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        }
        reindeers.add(reindeer);
    }

    private void iterateReindeers(List<Reindeer> reindeers, int time) {
        for (int i = 1; i <= time; i++) {
            for (Reindeer reindeer : reindeers) {
                reindeer.tick(i);
            }
            increaseBonusOfFrontrunningReindeer(reindeers);
        }
    }

    private void increaseBonusOfFrontrunningReindeer(List<Reindeer> reindeers) {
        int frontrunnersDistance = 0;
        for (Reindeer reindeer : reindeers) {
            if (reindeer.getDistance() > frontrunnersDistance) {
                frontrunnersDistance = reindeer.getDistance();
            }
        }
        for (Reindeer reindeer : reindeers) {
            if (reindeer.getDistance() == frontrunnersDistance) {
                reindeer.increasePoint();
            }
        }
    }

    int maxBonusFromFile(String filename, int time) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        return maxBonus(reindeers, time);
    }

    int maxBonus(List<Reindeer> reindeers, int time) {
        iterateReindeers(reindeers, time);
        return findReindeerByMaxBonus(reindeers);
    }

    private int findReindeerByMaxBonus(List<Reindeer> reindeers) {
        int maxPoints = 0;
        for (Reindeer reindeer : reindeers) {
            if (reindeer.getPoints() > maxPoints) {
                maxPoints = reindeer.getPoints();
            }
        }
        return maxPoints;
    }

}
