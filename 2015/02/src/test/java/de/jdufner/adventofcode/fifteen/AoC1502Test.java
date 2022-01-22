package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AoC1502Test {

    @Test
    void testExample1() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper(2, 3, 4);

        // assert
        assertEquals(58, squareFeetOfWrappingPaper);
    }

    @Test
    void testExample2() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper(1, 1, 10);

        // assert
        assertEquals(43, squareFeetOfWrappingPaper);
    }

    @Test
    void testExampleAsString1() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper("2x3x4");

        // assert
        assertEquals(58, squareFeetOfWrappingPaper);
    }

    @Test
    void testExampleAsString2() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper("1x1x10");

        // assert
        assertEquals(43, squareFeetOfWrappingPaper);
    }

    @Test
    void testParseString() {
        // arrange

        // act
        String[] strings = AoC1502.parseString("1x2x3");

        // assert
        assertArrayEquals(new String[]{"1", "2", "3"}, strings);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1502 aoC1502 = new AoC1502();

        // act
        int sumOfWrapperingPaper = aoC1502.calculateSumOfWrappingPaper("./src/test/resources/input");

        // assert
        assertEquals(1588178, sumOfWrapperingPaper);
    }

    @Test
    void part2() throws Exception {
        // arrange

        // act

        // assert
        assertTrue(false);
    }

}