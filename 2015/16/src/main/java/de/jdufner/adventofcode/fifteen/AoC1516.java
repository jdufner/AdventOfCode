package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1516 {

    private static final String FACTS = """
        children: 3
        cats: 7
        samoyeds: 2
        pomeranians: 3
        akitas: 0
        vizslas: 0
        goldfish: 5
        trees: 3
        cars: 2
        perfumes: 1""";
    private static final Pattern FACT_PATTERN = Pattern.compile("(\\w+): (\\d+)");
    private static final Pattern SUE_PATTERN = Pattern.compile("Sue (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");

    private List<Sue> listOfSues = new ArrayList<>();

    static Map<String, Integer> facts() {
        Map<String, Integer> facts = new HashMap<>();
        Matcher matcher = FACT_PATTERN.matcher(FACTS);
        while (matcher.find()) {
            facts.put(matcher.group(1), Integer.parseInt(matcher.group(2)));
        }
        return facts;
    }

    int filterSuePart1(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        int index = listOfSues.size() - 1;
        while (index >= 0) {
            Sue sue = listOfSues.get(index);
            boolean remove = sue.checkFactsPart1(facts());
            if (remove) {
                listOfSues.remove(sue);
            }
            index--;
        }
        return listOfSues.get(0).getId();
    }

    int filterSuePart2(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        int index = listOfSues.size() - 1;
        while (index >= 0) {
            Sue sue = listOfSues.get(index);
            boolean remove = sue.checkFactsPart2(facts());
            if (remove) {
                listOfSues.remove(sue);
            }
            index--;
        }
        return listOfSues.get(1).getId();
    }

    private void parseString(String line) {
        Matcher matcher = SUE_PATTERN.matcher(line);
        if (matcher.matches()) {
            listOfSues.add(new Sue(Integer.parseInt(matcher.group(1)),
                    matcher.group(2), Integer.parseInt(matcher.group(3)),
                    matcher.group(4), Integer.parseInt(matcher.group(5)),
                    matcher.group(6), Integer.parseInt(matcher.group(7))
                    ));
        }
    }

}
