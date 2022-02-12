package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

class AoC1517 {

    private final List<Integer> containers = new ArrayList<>();
    private final List<List<Integer>> validCombinations = new ArrayList<>();
    private final SortedMap<Integer, Integer> size2NumberMap = new TreeMap<>();

    public int readDataAndFindCombos(String filename, int size) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        findCombos(new ArrayList<Integer>(), containers, size);
        return validCombinations.size();
    }

    public int readDataAndFindShortestCombos(String filename, int size) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        findCombos(new ArrayList<Integer>(), containers, size);
        for (List<Integer> validCombination: validCombinations) {
            size2NumberMap.put(validCombination.size(), size2NumberMap.getOrDefault(validCombination.size(), 0) + 1);
        }
        return size2NumberMap.get(size2NumberMap.firstKey()).intValue();
    }

    private void findCombos(List<Integer> consumedContainers, List<Integer> remainingContainers, int size) {
        for (int i = 0; i < remainingContainers.size(); i++) {
            List<Integer> newConsumedContainers = new ArrayList<>(consumedContainers);
            newConsumedContainers.add(remainingContainers.get(i));
            List<Integer> newRemainingContainers = new ArrayList<>(remainingContainers);
            for (int j = 0; j <= i; j++) {
                newRemainingContainers.remove(0);
            }
            if (haveConsumedContainersRightSize(newConsumedContainers, size)) {
                List<Integer> validCombination = new ArrayList<>();
                validCombination.addAll(newConsumedContainers);
                validCombinations.add(validCombination);
                newConsumedContainers.remove(newConsumedContainers.size() - 1);
            } else {
                if (isConsumedContainersSizeTooBig(newConsumedContainers, size)) {
                    newConsumedContainers.remove(newConsumedContainers.size() - 1);
                } else {
                    findCombos(newConsumedContainers, newRemainingContainers, size);
                }
            }
        }
    }

    private boolean isConsumedContainersSizeTooBig(List<Integer> consumedContainers, int size) {
        return size < consumedContainers.stream().mapToInt(Integer::intValue).sum();
    }

    private boolean haveConsumedContainersRightSize(List<Integer> consumedContainers, int size) {
        return size == consumedContainers.stream().mapToInt(Integer::intValue).sum();
    }

    private void parseString(String line) {
        containers.add(Integer.parseInt(line));
    }

}
