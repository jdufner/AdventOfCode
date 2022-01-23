package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AoC1504Test {

    @Test
    void testPart1Example1() throws Exception {
        // arrange
        String secret = "abcdef";
        int answer = 609043;

        // act
        String s = AoC1504.calculateMD5(secret, answer);

        // assert
        assertTrue(s.startsWith("00000"));
    }

    @Test
    void testPart1Example2() throws Exception {
        // arrange
        String secret = "pqrstuv";
        int answer = 1048970;

        // act
        String s = AoC1504.calculateMD5(secret, answer);

        // assert
        assertTrue(s.startsWith("00000"));
    }

    @Test
    void testPart1Example1Suche() throws Exception {
        // arrange
        String secret = "abcdef";

        // act
        int i = AoC1504.findNumber(secret, "00000");

        // assert
        assertEquals(609043, i);
    }

    @Test
    void testPart1Example2Suche() throws Exception {
        // arrange
        String secret = "pqrstuv";

        // act
        int i = AoC1504.findNumber(secret, "00000");

        // assert
        assertEquals(1048970, i);
    }

    @Test
    void part1() throws Exception {
        // arrange
        String secret = "ckczppom";

        // act
        int i = AoC1504.findNumber(secret, "00000");

        // assert
        assertEquals(117946, i);
    }

    @Test
    void part2() throws Exception {
        // arrange
        String secret = "ckczppom";

        // act
        int i = AoC1504.findNumber(secret, "000000");

        // assert
        assertEquals(3938038, i);
    }

}
