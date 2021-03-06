package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AoC1501Test {

    @Test
    void testCountBrackets1() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("(");

        // assert
        assertEquals(1, level);
    }

    @Test
    void testCountBrackets2() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("(())");

        // assert
        assertEquals(0, level);
    }

    @Test
    void testCountBrackets3() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("()()");

        // assert
        assertEquals(0, level);
    }

    @Test
    void testCountBrackets4() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("(((");

        // assert
        assertEquals(3, level);
    }

    @Test
    void testCountBrackets5() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("(()(()(");

        // assert
        assertEquals(3, level);
    }

    @Test
    void testCountBrackets6() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("))(((((");

        // assert
        assertEquals(3, level);
    }

    @Test
    void testCountBrackets7() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("())");

        // assert
        assertEquals(-1, level);
    }

    @Test
    void testCountBrackets8() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets("))(");

        // assert
        assertEquals(-1, level);
    }

    @Test
    void testCountBrackets9() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets(")))");

        // assert
        assertEquals(-3, level);
    }

    @Test
    void testCountBrackets10() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets(")())())");

        // assert
        assertEquals(-3, level);
    }

    @Test
    void testLevelByOpeningBracket() {
        // arrange

        // act
        int level = AoC1501.levelByBracket('(');

        // assert
        assertEquals(1, level);
    }

    @Test
    void testLevelByClosingBracket() {
        // arrange

        // act
        int level = AoC1501.levelByBracket(')');

        // assert
        assertEquals(-1, level);
    }

    @Test
    void testLevelByNoBracket() {
        // arrange

        // act
        int level = AoC1501.levelByBracket(' ');

        // assert
        assertEquals(0, level);
    }

    @Test
    void testCountBracketsByBaseLevel1() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int index = aoC1501.countBracketsByBaseLevel(")");

        // assert
        assertEquals(1, index);
    }

    @Test
    void testCountBracketsByBaseLevel2() {
        // arrange
        AoC1501 aoC1501 = new AoC1501();

        // act
        int index = aoC1501.countBracketsByBaseLevel("()())");

        // assert
        assertEquals(5, index);
    }

    @Test
    void part1() throws Exception {
        // arrange
        Path filename = Path.of("./src/test/resources/input");
        String content = Files.readString(filename);
        AoC1501 aoC1501 = new AoC1501();

        // act
        int level = aoC1501.countBrackets(content);

        // assert
        assertEquals(74, level);
    }

    @Test
    void part2() throws Exception {
        // arrange
        Path filename = Path.of("./src/test/resources/input");
        String content = Files.readString(filename);
        AoC1501 aoC1501 = new AoC1501();

        // act
        int index = aoC1501.countBracketsByBaseLevel(content);

        // assert
        assertEquals(1795, index);
    }

}