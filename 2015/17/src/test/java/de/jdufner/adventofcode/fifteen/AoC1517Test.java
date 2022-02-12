package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1517Test {

    @Test
    void whenExampleExpect4Results() throws Exception {
        // arrange
        AoC1517 aoC1517 = new AoC1517();

        // act
        int combos = aoC1517.readDataAndFindCombos("./src/test/resources/test", 25);

        // assert
        assertThat(combos).isEqualTo(4);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1517 aoC1517 = new AoC1517();

        // act
        int combos = aoC1517.readDataAndFindCombos("./src/test/resources/input", 150);

        // assert
        assertThat(combos).isEqualTo(1304);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1517 aoC1517 = new AoC1517();

        // act
        int combos = aoC1517.readDataAndFindShortestCombos("./src/test/resources/input", 150);

        // assert
        assertThat(combos).isEqualTo(18);
    }

}
