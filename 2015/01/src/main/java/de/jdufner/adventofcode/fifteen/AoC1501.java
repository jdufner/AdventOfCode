package de.jdufner.adventofcode.fifteen;

import java.nio.charset.StandardCharsets;

class AoC1501 {

    static int levelByBracket(int bracket) {
        if (bracket == '(')
            return 1;
        if (bracket == ')')
            return -1;
        return 0;
    }

    int countBrackets(String s) {
        return s.chars().map(AoC1501::levelByBracket).sum();
    }

    int countBracketsByBaseLevel(String s) {
        int level = 0;
        int index = 0;
        byte[] chars = s.getBytes(StandardCharsets.UTF_8);
        while (level >= 0) {
            level += levelByBracket(chars[index]);
            index++;
        }
        return index;
    }

}
