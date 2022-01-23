package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class AoC1505 {

    static boolean containsAtLeastThreeVowels(String s) {
        int numberVowels = count('a', s) + count('e', s) + count('i', s) + count('o', s) + count('u', s);
        return numberVowels >= 3;
    }

    private static int count(char a, String s) {
        return (int) s.chars().filter(c -> c == a).count();
    }

    static boolean containsLetterTwiceInARow(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (int i = 1; i < bytes.length; i++) {
            if (bytes[i - 1] == bytes[i]) {
                return true;
            }
        }
        return false;
    }

    static boolean containsForbiddenSubstring(String s) {
        return s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy");
    }

    static boolean isNice1(String s) {
        return containsAtLeastThreeVowels(s) && containsLetterTwiceInARow(s) && !containsForbiddenSubstring(s);
    }

    static int countNice1(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return (int) stream.filter(AoC1505::isNice1).count();
        }
    }

    static boolean containsPairOfLettersAtLeastTwice(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        int i = 0;
        while (i < bytes.length - 1) {
            int j = i + 2;
            while (j < bytes.length - 1) {
                if (bytes[i] == bytes[j] && bytes[i + 1] == bytes[j + 1]) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    static boolean containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        int i = 0;
        while (i < bytes.length - 2) {
            if (bytes[i] == bytes[i + 2]) {
                return true;
            }
            i++;
        }
        return false;
    }

    static boolean isNice2(String s) {
        return containsPairOfLettersAtLeastTwice(s) && containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween(s);
    }

    static int countNice2(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return (int) stream.filter(AoC1505::isNice2).count();
        }
    }

}
