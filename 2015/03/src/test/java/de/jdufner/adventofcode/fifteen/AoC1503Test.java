package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AoC1503Test {

    @Test
    void testExample1() {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walk(">");

        // assert
        assertEquals(2, numberHouses);
    }

    @Test
    void testExample2() {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walk("^>v<");

        // assert
        assertEquals(4, numberHouses);
    }

    @Test
    void testExample3() {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walk("^v^v^v^v^v");

        // assert
        assertEquals(2, numberHouses);
    }

    @Test
    void testSantaAndRoboSantaExample1() {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walkSantaAndRoboSanta("^v");

        // assert
        assertEquals(3, numberHouses);
    }

    @Test
    void testSantaAndRoboSantaExample2() {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walkSantaAndRoboSanta("^>v<");

        // assert
        assertEquals(3, numberHouses);
    }

    @Test
    void testSantaAndRoboSantaExample3() {
        // arrange
        House.reset();

        // act
        int numberHouses = AoC1503.walkSantaAndRoboSanta("^v^v^v^v^v");

        // assert
        assertEquals(11, numberHouses);
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
        Path filename = Path.of("./src/test/resources/input");
        String content = Files.readString(filename);

        // act
        int numberHouses = AoC1503.walkSantaAndRoboSanta(content);

        // assert
        assertEquals(2631, numberHouses);
    }

}
