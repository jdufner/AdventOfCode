package de.jdufner.adventofcode.fifteen;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class AoC1502 {

    static int calculateSquareFeetOfWrappingPaper(int length, int width, int height) {
        int lengthWidth = length * width;
        int lengthHeight = length * height;
        int widthHeight = width * height;
        return lengthWidth * 2 + lengthHeight * 2 + widthHeight * 2 + smallest(lengthWidth, lengthHeight, widthHeight);
    }

    private static int smallest(int lengthWidth, int lengthHeight, int widthHeight) {
        if (lengthWidth < lengthHeight && lengthWidth < widthHeight) {
            return lengthWidth;
        }
        if (lengthHeight < widthHeight) {
            return lengthHeight;
        }
        return widthHeight;
    }

    static String[] parseString(String s) {
        return s.split("x");
    }

    static int calculateSquareFeetOfWrappingPaper(String s) {
        String[] strings = parseString(s);
        return calculateSquareFeetOfWrappingPaper(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]), Integer.valueOf(strings[2]));
    }

    int calculateSumOfWrappingPaper(String filename) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.mapToInt(AoC1502::calculateSquareFeetOfWrappingPaper).sum();
        }
        //return 0;
    }
}
