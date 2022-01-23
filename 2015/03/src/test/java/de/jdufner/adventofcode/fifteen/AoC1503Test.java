package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AoC1503Test {

    @Test
    void testExample1() throws Exception {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walk(">");

        // assert
        assertEquals(2, numberHouses);
    }

    @Test
    void testExample2() throws Exception {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walk("^>v<");

        // assert
        assertEquals(4, numberHouses);
    }

    @Test
    void testExample3() throws Exception {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walk("^v^v^v^v^v");

        // assert
        assertEquals(2, numberHouses);
    }

    @Test
    void part1() throws Exception {
        // arrange
        House.reset();
        Path filename = Path.of("./src/test/resources/input");
        String content = Files.readString(filename);

        // act
        int numberHouses = AoC1503.walk(content);

        // assert
        assertEquals(2572, numberHouses);
    }

    @Test
    void part2() throws Exception {
        // arrange
        House.reset();

        // act

        // assert
        assertTrue(false);
    }

}
