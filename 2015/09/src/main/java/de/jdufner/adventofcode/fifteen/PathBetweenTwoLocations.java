package de.jdufner.adventofcode.fifteen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PathBetweenTwoLocations {

    private static final Pattern pattern = Pattern.compile("(\\w+)\\s+to\\s+(\\w+)\\s+=\\s+(\\d+)");
    private static Set<String> locations = new HashSet<>();

    private final String fromLocation;
    private final String toLocation;
    private final int distance;

    PathBetweenTwoLocations(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            fromLocation = matcher.group(1);
            locations.add(fromLocation);
            toLocation = matcher.group(2);
            locations.add(toLocation);
            distance = Integer.parseInt(matcher.group(3));
        } else {
            throw new RuntimeException(s + " konnte nicht geparst werden!");
        }
    }

    String getFromLocation() {
        return fromLocation;
    }

    String getToLocation() {
        return toLocation;
    }

    int getDistance() {
        return distance;
    }

    boolean isOneOfAllLocations(String location) {
        return fromLocation.equals(location) || toLocation.equals(location);
    }

    boolean areLocations(String location1, String location2) {
        return  ((fromLocation.equals(location1) && toLocation.equals(location2)) ||
                (fromLocation.equals(location2) && toLocation.equals(location1)));
    }

    static void resetLocations() {
        locations = new HashSet<>();
    }

    static List<String> getLocations() {
        List<String> locations = new ArrayList<>();
        locations.addAll(PathBetweenTwoLocations.locations);
        return locations;
    }

}
