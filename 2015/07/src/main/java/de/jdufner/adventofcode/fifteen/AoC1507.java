package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1507 {

    private static final Pattern ASSIGNMENT_PATTERN = Pattern.compile("(\\w+)\\s+->\\s+(\\w+)");
    private static final Pattern UNARY_PATTERN = Pattern.compile("(NOT)\\s+(\\w+)\\s+->\\s+(\\w+)");
    private static final Pattern BINARY_PATTERN = Pattern.compile("(\\w+)\\s+(AND|OR|LSHIFT|RSHIFT)\\s+(\\w+)\\s+->\\s+(\\w+)");

    private final Collection<String> instructions = new ArrayList<>();
    private final Map<String, Integer> evaluated = new HashMap<>();

    void evaluate() {
        while (instructions.size() > 0) {
            for (var entry : instructions) {
                if (evaluateInstruction(entry)) {
                    instructions.remove(entry);
                    break;
                }
            }
        }
    }

    boolean evaluateInstruction(String s) {
        if (evaluateBinaryPattern(s) || evaluateUnaryPattern(s) || evaluateAssignment(s)) {
            return true;
        }
        return false;
    }

    private boolean evaluateAssignment(String s) {
        Matcher matcher = ASSIGNMENT_PATTERN.matcher(s);
        if (matcher.matches()) {
            if (variablesEvaluatedOrDigit(matcher.group(1))) {
                evaluated.put(matcher.group(2), buildValue(matcher.group(1)));
                return true;
            }
        }
        return false;
    }

    private boolean evaluateUnaryPattern(String s) {
        Matcher matcher = UNARY_PATTERN.matcher(s);
        if (matcher.matches()) {
            if (variablesEvaluatedOrDigit(matcher.group(2))) {
                evaluateNot(matcher.group(2), matcher.group(3));
                return true;
            }
        }
        return false;
    }

    private void evaluateNot(String group, String key) {
        int s = buildValue(group);
        int result = 65535 - s; //~s;
        evaluated.put(key, result);
    }

    private boolean evaluateBinaryPattern(String s) {
        Matcher matcher = BINARY_PATTERN.matcher(s);
        if (matcher.matches()) {
            if (variablesEvaluatedOrDigit(matcher.group(1), matcher.group(3))) {
                switch (matcher.group(2)) {
                    case "AND":
                        evaluateAnd(matcher.group(1), matcher.group(3), matcher.group(4));
                        break;
                    case "OR":
                        evaluateOr(matcher.group(1), matcher.group(3), matcher.group(4));
                        break;
                    case "LSHIFT":
                        evaluateLshift(matcher.group(1), matcher.group(3), matcher.group(4));
                        break;
                    case "RSHIFT":
                        evaluateRshift(matcher.group(1), matcher.group(3), matcher.group(4));
                        break;
                }
                return true;
            }
        }
        return false;
    }

    private void evaluateRshift(String group1, String group2, String key) {
        int s1 = buildValue(group1);
        int s2 = buildValue(group2);
        int result = s1 >> s2;
        evaluated.put(key, result);
    }

    private void evaluateLshift(String group1, String group2, String key) {
        int s1 = buildValue(group1);
        int s2 = buildValue(group2);
        int result = s1 << s2;
        evaluated.put(key, result);
    }

    private void evaluateOr(String group1, String group2, String key) {
        int s1 = buildValue(group1);
        int s2 = buildValue(group2);
        int result = s1 | s2;
        evaluated.put(key, result);
    }

    private void evaluateAnd(String group1, String group2, String key) {
        int s1 = buildValue(group1);
        int s2 = buildValue(group2);
        int result = s1 & s2;
        evaluated.put(key, result);
    }

    private int buildValue(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return evaluated.get(str);
        }
    }

    private boolean variablesEvaluatedOrDigit(String... variables) {
        for (String variable : variables) {
            if (!isDigit(variable) && evaluated.get(variable) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(String s) {
        try {
            Short.parseShort(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    void loadFile(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(instructions::add);
        }
    }

    public int getEvaluated(String s) {
        return evaluated.get(s);
    }
}
