package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1519Test {

    @Test
    void whenTestExpect4() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMoleculesPart1("./src/test/resources/test");

        // assert
        assertThat(molecules).isEqualTo(4);
    }

    @Test
    void whenTest2Expect4() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMoleculesPart1("./src/test/resources/test2");

        // assert
        assertThat(molecules).isEqualTo(7);
    }

    @Test
    void whenTest3Expect3() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMoleculesPart2b("./src/test/resources/test3");

        // assert
        assertThat(molecules).isEqualTo(3);
    }

    @Test
    void whenTest4Expect6() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMoleculesPart2b("./src/test/resources/test4");

        // assert
        assertThat(molecules).isEqualTo(6);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMoleculesPart1("./src/test/resources/input");

        // assert
        assertThat(molecules).isEqualTo(535);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMoleculesPart2b("./src/test/resources/input");

        // assert
        assertThat(molecules).isEqualTo(212);
    }

}
