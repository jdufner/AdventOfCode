package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1506Part2 {

    public static final String TURN_ON = "turn on";
    public static final String TOGGLE = "toggle";
    public static final String TURN_OFF = "turn off";
    private static final Pattern pattern = Pattern.compile("(" + TURN_ON + "|" + TOGGLE + "|" + TURN_OFF + ")\\s+(\\d+),(\\d+)\\s+through\\s+(\\d+),(\\d+)");

    int[][] lights = new int[1000][1000];

    void turnOn(int left, int top, int right, int bottom) {
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                lights[i][j]++;
            }
        }
    }

    void turnOff(int left, int top, int right, int bottom) {
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                if (lights[i][j]>0)
                lights[i][j]--;
            }
        }
    }

    void toggle(int left, int top, int right, int bottom) {
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                lights[i][j] += 2;
            }
        }
    }

    int sumLightsLit() {
        int lightsLit = 0;
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[0].length; j++) {
                lightsLit += lights[i][j];
            }
        }
        return lightsLit;
    }

    void switchLights(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            String cmd = matcher.group(1);
            int left = Integer.parseInt(matcher.group(2));
            int top = Integer.parseInt(matcher.group(3));
            int right = Integer.parseInt(matcher.group(4));
            int bottom = Integer.parseInt(matcher.group(5));
            switch (cmd) {
                case TURN_ON:
                    turnOn(left, top, right, bottom);
                    break;
                case TURN_OFF:
                    turnOff(left, top, right, bottom);
                    break;
                case TOGGLE:
                    toggle(left, top, right, bottom);
                    break;
            }
        }
    }

    void switchAllLights(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::switchLights);
        }
    }

}
