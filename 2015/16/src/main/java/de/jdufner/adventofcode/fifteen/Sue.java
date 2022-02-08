package de.jdufner.adventofcode.fifteen;

import java.util.HashMap;
import java.util.Map;

class Sue {

    private final int id;
    private final Map<String, Integer> properties = new HashMap<>();

    Sue(int id, String key1, int value1, String key2, int value2, String key3, int value3) {
        this.id = id;
        properties.put(key1, value1);
        properties.put(key2, value2);
        properties.put(key3, value3);
    }

    private boolean hasProperty(String key) {
        return properties.get(key) != null;
    }

    private int getValue(String key) {
        return properties.get(key).intValue();
    }

    boolean checkFactsPart1(Map<String, Integer> facts) {
        for (String key : properties.keySet()) {
            if (getValue(key) != facts.get(key).intValue()) {
                return true;
            }
        }
        return false;
    }

    boolean checkFactsPart2(Map<String, Integer> facts) {
        for (String key : properties.keySet()) {
            if (key.equals("cats") || key.equals("trees")) {
                if (getValue(key) < facts.get(key).intValue()) {
                    return true;
                }
            } else
            if (key.equals("pomeranians") || key.equals("goldfish")) {
                if (getValue(key) > facts.get(key).intValue()) {
                    return true;
                }
            } else
            if (getValue(key) != facts.get(key).intValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.valueOf(id);
    }

    int getId() {
        return id;
    }
}
