package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AoC1508Test {

    @Test
    void whenCountAllChars1ExpectLengthTwo() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countAllChars("\"\"");

        // assert
        assertEquals(2, length);
    }

    @Test
    void whenCountAllChars2ExpectLengthFive() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countAllChars("\"abc\"");

        // assert
        assertEquals(5, length);
    }

    @Test
    void whenCountAllChars3ExpectLengthTen() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countAllChars("\"aaa\\\"aaa\"");

        // assert
        assertEquals(10, length);
    }

    @Test
    void whenCountAllChars4ExpectLengthSix() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countAllChars("\"\\x27\"");

        // assert
        assertEquals(6, length);
    }

    @Test
    void whenCountEffectiveChars1ExpectLengthZero() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countEffectiveChars("\"\"");

        // assert
        assertEquals(0, length);
    }

    @Test
    void whenCountEffectiveChars2ExpectLengthThree() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countEffectiveChars("\"abc\"");

        // assert
        assertEquals(3, length);
    }

    @Test
    void whenCountEffectiveChars4ExpectLengthSix() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countEffectiveChars("\"aaa\\\"aaa\"");

        // assert
        assertEquals(7, length);
    }

    @Test
    void whenCountEffectiveChars4ExpectLength1() {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int length = aoC1508.countEffectiveChars("\"\\x27\"");

        // assert
        assertEquals(1, length);
    }

    @Test
    void whenDifferenceOfLine1() {
        // arange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int diff = aoC1508.difference("\"qxfcsmh\"");

        // assert
        assertEquals(2, diff);
    }

    @Test
    void whenDifferenceOfLine2() {
        // arange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int diff = aoC1508.difference("\"ffsfyxbyuhqkpwatkjgudo\"");

        // assert
        assertEquals(2, diff);
    }

    @Test
    void whenDifferenceOfLine3() {
        // arange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int diff = aoC1508.difference("\"byc\\x9dyxuafof\\\\\\xa6uf\\\\axfozomj\\\\olh\\x6a\"");

        // assert
        assertEquals(14, diff);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1508 aoC1508 = new AoC1508();

        // act
        int i = aoC1508.differencesOfStrings("./src/test/resources/input");

        // assert
        assertEquals(1350, i);
    }

    @Test
    void part2() throws Exception {
        // arrange

        // act

        // assert
        assertTrue(false);
    }

}
