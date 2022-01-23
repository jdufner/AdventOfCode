package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AoC1505Test {

    @Test
    void whenCountExpectNumberVowels1() {
        // arrange

        // act
        boolean moreThanThreeVowels = AoC1505.containsAtLeastThreeVowels("aeiou");

        // assert
        assertTrue(moreThanThreeVowels);
    }

    @Test
    void whenCountExpectNumberVowels2() {
        // arrange

        // act
        boolean moreThanThreeVowels = AoC1505.containsAtLeastThreeVowels("aei");

        // assert
        assertTrue(moreThanThreeVowels);
    }

    @Test
    void whenCountExpectNumberVowels3() {
        // arrange

        // act
        boolean moreThanThreeVowels = AoC1505.containsAtLeastThreeVowels("xazegov");

        // assert
        assertTrue(moreThanThreeVowels);
    }

    @Test
    void whenCountExpectNumberVowels4() {
        // arrange

        // act
        boolean moreThanThreeVowels = AoC1505.containsAtLeastThreeVowels("aeiouaeiouaeiou");

        // assert
        assertTrue(moreThanThreeVowels);
    }

    @Test
    void whenContainsLetterTwiceInARow1() {
        // arrange

        // act
        boolean twiceInARow = AoC1505.containsLetterTwiceInARow("abcdde");

        // assert
        assertTrue(twiceInARow);
    }

    @Test
    void whenContainsLetterTwiceInARow2() {
        // arrange

        // act
        boolean twiceInARow = AoC1505.containsLetterTwiceInARow("aabbccdd");

        // assert
        assertTrue(twiceInARow);
    }

    @Test
    void whenIsNice1ExpectTrue1() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice1("ugknbfddgicrmopn");

        // assert
        assertTrue(isNice);
    }

    @Test
    void whenIsNice1ExpectTrue2() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice1("aaa");

        // assert
        assertTrue(isNice);
    }

    @Test
    void whenIsNice1ExpectTrue3() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice1("jchzalrnumimnmhp");

        // assert
        assertFalse(isNice);
    }

    @Test
    void whenIsNice1ExpectTrue4() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice1("haegwjzuvuyypxyu");

        // assert
        assertFalse(isNice);
    }

    @Test
    void whenIsNice1ExpectTrue5() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice1("dvszwmarrgswjxmb");

        // assert
        assertFalse(isNice);
    }

    @Test
    void whenContainsPairOfLettersAtLeastTwiceExpectTrue1() {
        // arrange

        // act
        boolean containsPairOfLettersAtLeastTwice = AoC1505.containsPairOfLettersAtLeastTwice("xyxy");

        // assert
        assertTrue(containsPairOfLettersAtLeastTwice);
    }

    @Test
    void whenContainsPairOfLettersAtLeastTwiceExpectTrue2() {
        // arrange

        // act
        boolean containsPairOfLettersAtLeastTwice = AoC1505.containsPairOfLettersAtLeastTwice("aabcdefgaa");

        // assert
        assertTrue(containsPairOfLettersAtLeastTwice);
    }

    @Test
    void whenContainsPairOfLettersAtLeastTwiceExpectFalse3() {
        // arrange

        // act
        boolean containsPairOfLettersAtLeastTwice = AoC1505.containsPairOfLettersAtLeastTwice("aaa");

        // assert
        assertFalse(containsPairOfLettersAtLeastTwice);
    }

    @Test
    void whenContainsOneLetterWhichRepeatsWithExactlyOneLetterInBetween1() {
        // arrange

        // act
        boolean containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween = AoC1505.containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween("xyx");

        // assert
        assertTrue(containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween);
    }

    @Test
    void whenContainsOneLetterWhichRepeatsWithExactlyOneLetterInBetween2() {
        // arrange

        // act
        boolean containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween = AoC1505.containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween("abcdefeghi");

        // assert
        assertTrue(containsOneLetterWhichRepeatsWithExactlyOneLetterInBetween);
    }

    @Test
    void whenIsNice2ExpectTrue1() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice2("qjhvhtzxzqqjkmpb");

        // assert
        assertTrue(isNice);
    }

    @Test
    void whenIsNice2ExpectTrue2() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice2("xxyxx");

        // assert
        assertTrue(isNice);
    }

    @Test
    void whenIsNice2ExpectFalse3() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice2("uurcxstgmygtbstg");

        // assert
        assertFalse(isNice);
    }

    @Test
    void whenIsNice2ExpectFalse4() {
        // arrange

        // act
        boolean isNice = AoC1505.isNice2("ieodomkazucvgmuy");

        // assert
        assertFalse(isNice);
    }

    @Test
    void part1() throws Exception {
        // arrange

        // act
        int numberNiceString = AoC1505.countNice1("./src/test/resources/input");

        // assert
        assertEquals(238, numberNiceString);
    }

    @Test
    void part2() throws Exception {
        // arrange

        // act
        int numberNiceString = AoC1505.countNice2("./src/test/resources/input");

        // assert
        assertEquals(69, numberNiceString);
    }

}
