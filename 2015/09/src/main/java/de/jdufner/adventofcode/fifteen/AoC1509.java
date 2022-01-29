package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

class AoC1509 {

    private final Collection<PathBetweenTwoLocations> pathBetweenTwoLocations = new ArrayList<>();
    private final SortedMap<Integer, Collection<String>> completePaths = new TreeMap<>();

    void loadLocations(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::buildPathBetweenTwoLocations);
        }
    }

    void buildPathBetweenTwoLocations(String s) {
        pathBetweenTwoLocations.add(new PathBetweenTwoLocations(s));
    }

    Collection<PathBetweenTwoLocations> getPathBetweenTwoLocations() {
        return pathBetweenTwoLocations;
    }

    void findShortestPath(List<String> locationsAlreadyVisited, List<String> locationsToVisit, int distance) {
        for (String location : locationsToVisit) {
            if (isLocationAllowedToBeVisitedNext(locationsAlreadyVisited, location)) {
                int newDistance = distance + retrieveDistance(locationsAlreadyVisited, location);
                List<String> newLocationsAlreadyVisited = new ArrayList<>();
                newLocationsAlreadyVisited.addAll(locationsAlreadyVisited);
                newLocationsAlreadyVisited.add(location);
                List<String> newLocationsToVisit = new ArrayList<>();
                newLocationsToVisit.addAll(locationsToVisit);
                newLocationsToVisit.remove(location);
                if (newLocationsToVisit.isEmpty()) {
                    // We are done!
                    //System.out.println(newLocationsAlreadyVisited + " has distance " + newDistance);
                    completePaths.put(newDistance, newLocationsAlreadyVisited);
                } else {
                    findShortestPath(newLocationsAlreadyVisited, newLocationsToVisit, newDistance);
                }
            }
        }
    }

    private int retrieveDistance(List<String> locationsAlreadyVisited, String location) {
        if (locationsAlreadyVisited.isEmpty()) {
            return 0;
        }
        return distanceBetweenLocations(locationsAlreadyVisited.get(locationsAlreadyVisited.size() - 1), location);
    }

    private int distanceBetweenLocations(String location1, String location2) {
        for (PathBetweenTwoLocations pathBetweenTwoLocations : pathBetweenTwoLocations) {
            if (pathBetweenTwoLocations.areLocations(location1, location2)) {
                return pathBetweenTwoLocations.getDistance();
            }
        }
        return 0;
    }

    private boolean isLocationAllowedToBeVisitedNext(List<String> locationsAlreadyVisited, String location) {
        if (locationsAlreadyVisited.isEmpty()) {
            return true;
        }
        return existAPathBetweenLocations(locationsAlreadyVisited.get(locationsAlreadyVisited.size() - 1), location);
    }

    private boolean existAPathBetweenLocations(String location1, String location2) {
        for (PathBetweenTwoLocations pathBetweenTwoLocations : pathBetweenTwoLocations) {
            if (pathBetweenTwoLocations.areLocations(location1, location2)) {
                return true;
            }
        }
        return false;
    }

    int getSmallestCompletePath() {
        return completePaths.firstKey();
    }

    int getLargestCompletePath() {
        return completePaths.lastKey();
    }
}
