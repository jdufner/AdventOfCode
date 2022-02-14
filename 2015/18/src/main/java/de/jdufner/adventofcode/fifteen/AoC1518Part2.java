package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class AoC1518Part2 {

    private char[][] grid = null;
    private int lineNumber = 0;

    public int readGridFromFileAndIterate(String filename, int iterations) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        char[][] finalGrid = iterate(grid, iterations);
        return count(finalGrid);
    }

    private char[][] iterate(char[][] grid, int iterations) {
        char[][] tmp1 = grid;
        char[][] tmp2 = new char[grid[0].length][grid.length];
        for (int i = 0; i < iterations; i++) {
            switchLights(tmp1, tmp2);
            tmp1 = tmp2;
            tmp2 = new char[grid[0].length][grid.length];
        }
        return tmp1;
    }

    private void switchLights(char[][] in, char[][] out) {
        for (int i = 0; i < in[0].length; i++) {
            for (int j = 0; j < in.length; j++) {
                int enlightedNeighbors = countEnlightedNeighbors(in, j, i);
                out[j][i] = '.';
                if (in[j][i] == '#') {
                    if (2 == enlightedNeighbors || 3 == enlightedNeighbors) {
                        out[j][i] = '#';
                    }
                } else {
                    if (3 == enlightedNeighbors) {
                        out[j][i] = '#';
                    }
                }
                if ((i == 0 && j == 0) ||
                        (i == 0 && j == in.length - 1) ||
                        (i == in.length - 1 && j == in.length - 1) ||
                        (i == in.length - 1 && j == 0)) {
                    out[j][i] = '#';
                }
            }
        }
    }

    private int countEnlightedNeighbors(char[][] in, int j, int i) {
        int counter = 0;
        if (j >= 0 && j + 1 < in.length) {
            if (in[j + 1][i] == '#') {
                counter++;
            }
            if (i >= 0 && i + 1 < in[0].length) {
                if (in[j + 1][i + 1] == '#') {
                    counter++;
                }
            }
            if (i - 1 >= 0 && i < in[0].length) {
                if (in[j + 1][i - 1] == '#') {
                    counter++;
                }
            }
        }
        if (j - 1 >= 0 && j < in.length) {
            if (in[j - 1][i] == '#') {
                counter++;
            }
            if (i >= 0 && i + 1 < in[0].length) {
                if (in[j - 1][i + 1] == '#') {
                    counter++;
                }
            }
            if (i - 1 >= 0 && i < in[0].length) {
                if (in[j - 1][i - 1] == '#') {
                    counter++;
                }
            }
        }
        if (j >= 0 && j < in.length) {
            if (i >= 0 && i + 1 < in[0].length) {
                if (in[j][i + 1] == '#') {
                    counter++;
                }
            }
            if (i - 1 >= 0 && i < in[0].length) {
                if (in[j][i - 1] == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int count(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private void parseString(String line) {
        if (grid == null) {
            grid = new char[line.length()][line.length()];
        }
        byte[] chars = line.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < chars.length; i++) {
            grid[lineNumber][i] = (char) chars[i];
        }
        lineNumber++;
    }

}
