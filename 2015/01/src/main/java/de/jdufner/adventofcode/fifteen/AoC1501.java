package de.jdufner.adventofcode.fifteen;

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


}
