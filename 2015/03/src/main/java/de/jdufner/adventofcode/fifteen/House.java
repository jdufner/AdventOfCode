package de.jdufner.adventofcode.fifteen;

import java.util.HashMap;
import java.util.Map;

class House {

    static Map<String, House> mapOfHouses = new HashMap<>();

    private final int x;
    private final int y;

    House(int x, int y) {
        this.x = x;
        this.y = y;
        mapOfHouses.put(buildKey(), this);
    }

    static void reset() {
        mapOfHouses = new HashMap<>();
    }

    static int getNumberAllHouses() {
        return mapOfHouses.size();
    }

    private String buildKey() {
        return buildKey(x, y);
    }

    private String buildKey(int x, int y) {
        return "x=" + x + ", y=" + y;
    }

    House move(byte c) {
        if (c == '^') {
            return top();
        }
        if (c == '>') {
            return right();
        }
        if (c == 'v') {
            return bottom();
        }
        if (c == '<') {
            return left();
        }
        return this;
    }

    House top() {
        String key = buildKey(x, y - 1);
        House h = mapOfHouses.get(key);
        if (h == null) {
            h = new House(x, y - 1);
        }
        return h;
    }

    House right() {
        String key = buildKey(x + 1, y);
        House h = mapOfHouses.get(key);
        if (h == null) {
            h = new House(x + 1, y);
        }
        return h;
    }

    House bottom() {
        String key = buildKey(x, y + 1);
        House h = mapOfHouses.get(key);
        if (h == null) {
            h = new House(x, y + 1);
        }
        return h;
    }

    House left() {
        String key = buildKey(x - 1, y);
        House h = mapOfHouses.get(key);
        if (h == null) {
            h = new House(x - 1, y);
        }
        return h;
    }

}
