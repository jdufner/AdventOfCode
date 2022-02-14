package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1519Test {

    @Test
    void whenTestExpect4() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMolecules("./src/test/resources/test");

        // assert
        assertThat(molecules).isEqualTo(4);
    }

    @Test
    void whenTest2Expect4() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMolecules("./src/test/resources/test2");

        // assert
        assertThat(molecules).isEqualTo(7);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1519 aoC1519 = new AoC1519();

        // act
        int molecules = aoC1519.countDistinctMolecules("./src/test/resources/input");

        // assert
        assertThat(molecules).isEqualTo(535);
    }

}
