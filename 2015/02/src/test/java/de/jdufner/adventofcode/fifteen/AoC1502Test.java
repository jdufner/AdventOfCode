package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AoC1502Test {

    @Test
    void testWrappingPaperExample1() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper(2, 3, 4);

        // assert
        assertEquals(58, squareFeetOfWrappingPaper);
    }

    @Test
    void testWrappingPaperExample2() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper(1, 1, 10);

        // assert
        assertEquals(43, squareFeetOfWrappingPaper);
    }

    @Test
    void testWrappingPaperExampleAsString1() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper("2x3x4");

        // assert
        assertEquals(58, squareFeetOfWrappingPaper);
    }

    @Test
    void testWrappingPaperExampleAsString2() {
        // arrange

        // act
        int squareFeetOfWrappingPaper = AoC1502.calculateSquareFeetOfWrappingPaper("1x1x10");

        // assert
        assertEquals(43, squareFeetOfWrappingPaper);
    }

    @Test
    void testRibbonExample1() {
        // arrange

        // act
        int lengthOfRibbon = AoC1502.calculateLengthOfRibbon(2, 3, 4);

        // assert
        assertEquals(34, lengthOfRibbon);
    }

    @Test
    void testRibbonExample2() {
        // arrange

        // act
        int lengthOfRibbon = AoC1502.calculateLengthOfRibbon(1, 1, 10);

        // assert
        assertEquals(14, lengthOfRibbon);
    }

    @Test
    void testRibbonExampleAsString1() {
        // arrange

        // act
        int lengthOfRibbon = AoC1502.calculateLengthOfRibbon("2x3x4");

        // assert
        assertEquals(34, lengthOfRibbon);
    }

    @Test
    void testRibbonExampleAsString2() {
        // arrange

        // act
        int lengthOfRibbon = AoC1502.calculateLengthOfRibbon("1x1x10");

        // assert
        assertEquals(14, lengthOfRibbon);
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
        AoC1502 aoC1502 = new AoC1502();

        // act
        int sumOfRibbon = aoC1502.calculateSumOfRibbon("./src/test/resources/input");

        // assert
        assertEquals(3783758, sumOfRibbon);
    }

}
