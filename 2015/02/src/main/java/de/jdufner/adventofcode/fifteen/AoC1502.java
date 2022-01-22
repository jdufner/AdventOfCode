package de.jdufner.adventofcode.fifteen;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class AoC1502 {

    static int calculateSquareFeetOfWrappingPaper(String s) {
        String[] strings = parseString(s);
        return calculateSquareFeetOfWrappingPaper(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
    }

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

    int calculateSumOfWrappingPaper(String filename) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.mapToInt(AoC1502::calculateSquareFeetOfWrappingPaper).sum();
        }
    }

    static int calculateLengthOfRibbon(String s) {
        String[] strings = parseString(s);
        return calculateLengthOfRibbon(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
    }

    static int calculateLengthOfRibbon(int length, int width, int height) {
        return doubleLengthOfSmallestTwo(length, width, height) + volume(length, width, height);
    }

    private static int doubleLengthOfSmallestTwo(int length, int width, int height) {
        if (length >= width && length >= height) {
            return width * 2 + height * 2;
        }
        if (width >= length && width >= height) {
            return length * 2 + height * 2;
        }
        return length * 2 + width * 2;
    }

    private static int volume(int length, int width, int height) {
        return length * width * height;
    }

    public int calculateSumOfRibbon(String filename) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.mapToInt(AoC1502::calculateLengthOfRibbon).sum();
        }
    }

}
