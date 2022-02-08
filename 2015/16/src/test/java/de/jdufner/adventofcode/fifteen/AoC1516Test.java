package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1516Test {

    @Test
    void whenParseFactsExpects9Cats() {
        // arrange

        // act
        int cats = AoC1516.facts().get("cats");

        // assert
        assertThat(cats).isEqualTo(7);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1516 aoC1516 = new AoC1516();

        // act
        int sue = aoC1516.filterSuePart1("./src/test/resources/input");

        // assert
        assertThat(sue).isEqualTo(103);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1516 aoC1516 = new AoC1516();

        // act
        int sue = aoC1516.filterSuePart2("./src/test/resources/input");

        // assert
        assertThat(sue).isEqualTo(405);
    }

}
