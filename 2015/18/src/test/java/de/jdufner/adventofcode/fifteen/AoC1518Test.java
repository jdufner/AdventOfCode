package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1518Test {

    @Test
    void whenTest1Expect4() throws Exception {
        // arrange
        AoC1518Part1 aoC1518Part1 = new AoC1518Part1();

        // act
        int combos = aoC1518Part1.readGridFromFileAndIterate("./src/test/resources/test", 4);

        // assert
        assertThat(combos).isEqualTo(4);
    }

    @Test
    void whenTest2Expect17() throws Exception {
        // arrange
        AoC1518Part2 aoC1518Part2 = new AoC1518Part2();

        // act
        int combos = aoC1518Part2.readGridFromFileAndIterate("./src/test/resources/test2", 5);

        // assert
        assertThat(combos).isEqualTo(17);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1518Part1 aoC1518Part1 = new AoC1518Part1();

        // act
        int combos = aoC1518Part1.readGridFromFileAndIterate("./src/test/resources/input", 100);

        // assert
        assertThat(combos).isEqualTo(1061);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1518Part2 aoC1518Part2 = new AoC1518Part2();

        // act
        int combos = aoC1518Part2.readGridFromFileAndIterate("./src/test/resources/input2", 100);

        // assert
        assertThat(combos).isEqualTo(1006);
    }

}
