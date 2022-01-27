package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1508 {

    Pattern pattern = Pattern.compile("(\")|(\\\\\\\\)|(\\\\\")|(\\\\x[0-9a-f]{2})");

    int countAllChars(String s) {
        return s.length();
    }

    int countEffectiveChars(String s) {
        Matcher matcher = pattern.matcher(s);
        int index = 0;
        int chars = 0;
        while (index < s.length()) {
            if (matcher.find(index)) {
                String str = matcher.group();
                int strIndex = matcher.start();
                if (index > 0 && strIndex < s.length()-1) {
                    chars += 1;
                }
                chars += strIndex - index;
                index = strIndex + str.length();
            }
        }
        return chars;
    }

    int difference(String s) {
        int allChars = countAllChars(s);
        int effectiveChars = countEffectiveChars(s);
        return allChars - effectiveChars;
    }

    int differencesOfStrings(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.mapToInt(this::difference).sum();
        }
    }

}
