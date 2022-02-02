package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AoC1512 {

    private final static Pattern DIGIT_PATTERN = Pattern.compile("(-?\\d+)");
    private final static Pattern OBJECT_WITHOUT_ARRAY_PATTERN = Pattern.compile("\\{[a-z\\\"\\:\\-0-9,]+?\\}");
    private final static Pattern ARRAY_PATTERN = Pattern.compile("\\[[a-z\\\"\\:\\-0-9,]+?\\]");

    int sumDigits(String s) {
        int sum = 0;
        Matcher matcher = DIGIT_PATTERN.matcher(s);
        while (matcher.find()) {
            int i = Integer.parseInt(matcher.group());
            sum += i;
        }
        return sum;
    }

    int sumDigitsFromFile(String filename) throws IOException {
        Path path = Path.of(filename);
        String content = Files.readString(path);
        return sumDigits(content);
    }

    int parseString(String s) {
        String str = s;
        boolean changed = true;
        while (changed) {
            Matcher m1 = OBJECT_WITHOUT_ARRAY_PATTERN.matcher(str);
            if (m1.find()) {
                String group = m1.group();
                String replacement = null;
                if (group.contains("red")) {
                    replacement = "0";
                } else {
                    replacement = String.valueOf(sumDigits(group));
                }
                //System.out.println(group + " -> " + replacement);
                str = str.replace(group, replacement);
                changed = true;
                continue;
            } else {
                changed = false;
            }
            Matcher m2 = ARRAY_PATTERN.matcher(str);
            if (m2.find()) {
                String group = m2.group();
                String replacement = String.valueOf(sumDigits(group));
                //System.out.println(group + " -> " + replacement);
                str = str.replace(group, replacement);
                changed = true;
                continue;
            } else {
                changed = false;
            }
        }
        return Integer.parseInt(str.trim());
    }

    public int sumDigitsWithoutRedObjectsFromFile(String filename) throws IOException {
        Path path = Path.of(filename);
        String content = Files.readString(path);
        return parseString(content);
    }
}
