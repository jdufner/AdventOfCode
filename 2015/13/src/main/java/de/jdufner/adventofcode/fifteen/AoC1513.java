package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1513 {

    private static final Pattern LINE_PATTERN = Pattern.compile("^(\\w+) would (gain|lose) (\\d+) happiness units by sitting next to (\\w+).$");

    private List<Happiness> happinessList = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private SortedMap<Integer, List<String>> happinessToSeatingArrangement = new TreeMap<>();

    int maximize(String s) {
        parseStringToNamesAndListOfHappiness(s);
        findMaxHappiness(new ArrayList<String>(), names);
        return happinessToSeatingArrangement.lastKey();
    }

    private void findMaxHappiness(List<String> seatingArrangement, List<String> names) {
        for (String name: names) {
            List<String> newSeatingArrangements = new ArrayList<>();
            newSeatingArrangements.addAll(seatingArrangement);
            newSeatingArrangements.add(name);
            List<String> newNames = new ArrayList<>();
            newNames.addAll(names);
            newNames.remove(name);
            if (newSeatingArrangements.size() < this.names.size()) {
                findMaxHappiness(newSeatingArrangements, newNames);
            } else {
                int happiness = calculateHappiness(newSeatingArrangements);
                happinessToSeatingArrangement.put(happiness, new ArrayList<>(newSeatingArrangements));
            }
        }
    }

    private int calculateHappiness(List<String> newSeatingArrangements) {
        int happiness = 0;
        for (int i = 0; i < newSeatingArrangements.size(); i++) {
            if (i+1 >= newSeatingArrangements.size()) {
                happiness += findHappinessFactorRightHand(newSeatingArrangements.get(i), newSeatingArrangements.get(0));
                happiness += findHappinessFactorRightHand(newSeatingArrangements.get(0), newSeatingArrangements.get(i));
            } else {
                happiness += findHappinessFactorRightHand(newSeatingArrangements.get(i), newSeatingArrangements.get(i + 1));
                happiness += findHappinessFactorRightHand(newSeatingArrangements.get(i + 1), newSeatingArrangements.get(i));
            }
        }
        return happiness;
    }

    private int findHappinessFactorRightHand(String from, String to) {
        for (Happiness h: happinessList) {
            if (h.getFrom().equals(from) && h.getTo().equals(to)) {
                return h.getFactor();
            }
        }
        throw new RuntimeException("Kein Happinessobjekt gefunden!");
    }

    private void parseStringToNamesAndListOfHappiness(String s) {
        Scanner scanner = new Scanner(s);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            parseStringToHappiness(line);
        }
        buildNamesFromHappinessList();
    }

    private void buildNamesFromHappinessList() {
        for (Happiness h : happinessList) {
            if (!names.contains(h.getFrom())) {
                names.add(h.getFrom());
            }
        }
    }

    private void parseStringToHappiness(String line) {
        Matcher matcher = LINE_PATTERN.matcher(line);
        if (matcher.matches()) {
            Happiness h = new Happiness(matcher.group(1), matcher.group(4), matcher.group(2), matcher.group(3));
            happinessList.add(h);
        }
    }

    int maximizeFromFile(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseStringToHappiness);
        }
        buildNamesFromHappinessList();
        findMaxHappiness(new ArrayList<String>(), names);
        return happinessToSeatingArrangement.lastKey();
    }
}
