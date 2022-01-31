package de.jdufner.adventofcode.fifteen;

import java.nio.charset.StandardCharsets;

class AoC1511 {

    private static final String[] FORBIDDEN_CHARS = new String[]{"i", "o", "l"};

    boolean containsThreeLettersInAStraight(String password) {
        int index = 0;
        while (index < password.length() - 2) {
            String threeLettersInAStraight = generateThreeLettersInAStraightStartingWith(password.charAt(index));
            if (password.subSequence(index, index + 3).equals(threeLettersInAStraight)) {
                return true;
            }
            index++;
        }
        return false;
    }

    private String generateThreeLettersInAStraightStartingWith(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(Character.valueOf((char) (c + 1)));
        sb.append(Character.valueOf((char) (c + 2)));
        return sb.toString();
    }

    boolean containsForbiddenChar(String password) {
        int index = 0;
        while (index < FORBIDDEN_CHARS.length) {
            if (password.contains(FORBIDDEN_CHARS[index])) {
                return true;
            }
            index++;
        }
        return false;
    }

    boolean containsTwoDifferentNonOverlappingPairsOfLetters(String password) {
        String firstPairOfLetter = null;
        String secondPairOfLetter = null;
        int index = 0;
        while (index < password.length() - 1) {
            if (password.substring(index, index + 1).equals(password.substring(index + 1, index + 2))) {
                if (firstPairOfLetter == null) {
                    firstPairOfLetter = String.valueOf(password.charAt(index) + password.charAt(index + 1));
                } else {
                    secondPairOfLetter = String.valueOf(password.charAt(index) + password.charAt(index + 1));
                    if (!firstPairOfLetter.equals(secondPairOfLetter)) {
                        return true;
                    }
                }
            }
            index++;
        }
        return false;
    }

    String incrementString(String password) {
        byte[] nextPasswort = new byte[password.length()];
        byte[] passwordAsByteArray = password.getBytes(StandardCharsets.UTF_8);
        boolean incrementNext = true;
        for (int i = 0; i < passwordAsByteArray.length; i++) {
            if (incrementNext) {
                if (passwordAsByteArray[passwordAsByteArray.length - 1 - i] == 'z') {
                    nextPasswort[passwordAsByteArray.length - 1 - i] = 'a';
                    incrementNext = true;
                } else {
                    nextPasswort[passwordAsByteArray.length - 1 - i] = (byte) (passwordAsByteArray[passwordAsByteArray.length - 1 - i] + 1);
                    incrementNext = false;
                }
            } else {
                nextPasswort[passwordAsByteArray.length - 1 - i] = passwordAsByteArray[passwordAsByteArray.length - 1 - i];
            }
        }
        return new String(nextPasswort);
    }

    boolean isValidPassword(String password) {
        return containsThreeLettersInAStraight(password) && !containsForbiddenChar(password) && containsTwoDifferentNonOverlappingPairsOfLetters(password);
    }

    String getNextValidPassword(String password) {
        String lastPassword = password;
        boolean found = false;
        while (true) {
            String nextPasswordCandidate = incrementString(lastPassword);
            if (isValidPassword(nextPasswordCandidate)) {
                return nextPasswordCandidate;
            } else {
                lastPassword = nextPasswordCandidate;
            }
        }
    }

}
