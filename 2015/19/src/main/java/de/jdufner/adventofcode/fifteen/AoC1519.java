package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1519 {

    private static final Pattern REPLACEMENT_PATTERN = Pattern.compile("^(\\w+) => (\\w+)$");
    private static final Pattern MOLECULE_PATTERN = Pattern.compile("^(\\w+)$");

    private final List<Replacement> replacements = new ArrayList<>();
    private final Set<String> molecules = new HashSet<>();

    public int countDistinctMoleculesPart1(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        Set<String> nextGenMolecules = iterate(molecules);
        return nextGenMolecules.size();
    }

    public int countDistinctMoleculesPart2b(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        replacements.sort((o1, o2) -> o2.to().length() - o1.to().length());
        return inverseRecursive(1, molecules);
    }

    private int inverseRecursive(int steps, Set<String> molecules) {
        Set<String> previousGenMolecules = inverse(molecules);
        if (previousGenMolecules.contains("e")) {
            return steps;
        } else {
            return inverseRecursive(steps + 1, previousGenMolecules);
        }
    }

    private Set<String> inverse(Set<String> molecules) {
        Set<String> previousGenMolecules = new HashSet<>();
        int i = 0;
        for (String molecule : molecules) {
            if (i < 1000) {
                int index = 0;
                while (index < molecule.length()) {
                    for (Replacement replacement : replacements) {
                        if (replacement.from().equals("e") && !replacement.to().equals(molecule)) {
                            continue;
                        }
                        if (index + replacement.to().length() <= molecule.length()) {
                            String substring = molecule.substring(index, index + replacement.to().length());
                            if (substring.equals(replacement.to())) {
                                String previousGenMolecule = replace(molecule, index, replacement.to().length(), replacement.from());
                                previousGenMolecules.add(previousGenMolecule);
                            }
                        }
                    }
                    index++;
                }
            }
            i++;
        }
        return previousGenMolecules;
    }

    private String replace(String molecule, int index, int length, String replacement) {
        String prefix = molecule.substring(0, index);
        String postfix = molecule.substring(index + length);
        return prefix + replacement + postfix;
    }

    private Set<String> iterate(Set<String> molecules) {
        Set<String> nextGenMolecules = new HashSet<>();
        for (String molecule : molecules) {
            for (Replacement replacement : replacements) {
                int index = 0;
                while (molecule.indexOf(replacement.from(), index) >= 0) {
                    index = molecule.indexOf(replacement.from(), index);
                    String prefix = molecule.substring(0, index);
                    String infix = replacement.to();
                    String postfix = molecule.substring(index + replacement.from().length());
                    String nextGenMolecule = prefix + infix + postfix;
                    nextGenMolecules.add(nextGenMolecule);
                    index = index + replacement.from().length();
                }
            }
        }
        return nextGenMolecules;
    }

    private void parseString(String line) {
        Matcher replacementMatcher = REPLACEMENT_PATTERN.matcher(line);
        if (replacementMatcher.matches()) {
            Replacement replacement = new Replacement(replacementMatcher.group(1), replacementMatcher.group(2));
            replacements.add(replacement);
        }
        Matcher moleculeMatcher = MOLECULE_PATTERN.matcher(line);
        if (moleculeMatcher.matches()) {
            String molecule = moleculeMatcher.group(1);
            molecules.add(molecule);
        }
    }

}
