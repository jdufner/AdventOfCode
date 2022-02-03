package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1513Test {

    @Test
    void whenMaximizeExampleExpect330() {
        // arrange
        AoC1513 aoC1513 = new AoC1513();
        String s = """
Alice would gain 54 happiness units by sitting next to Bob.
Alice would lose 79 happiness units by sitting next to Carol.
Alice would lose 2 happiness units by sitting next to David.
Bob would gain 83 happiness units by sitting next to Alice.
Bob would lose 7 happiness units by sitting next to Carol.
Bob would lose 63 happiness units by sitting next to David.
Carol would lose 62 happiness units by sitting next to Alice.
Carol would gain 60 happiness units by sitting next to Bob.
Carol would gain 55 happiness units by sitting next to David.
David would gain 46 happiness units by sitting next to Alice.
David would lose 7 happiness units by sitting next to Bob.
David would gain 41 happiness units by sitting next to Carol.""";

        // act
        int i = aoC1513.maximize(s);

        // assert
        assertThat(i).isEqualTo(330);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1513 aoC1513 = new AoC1513();

        // act
        int i = aoC1513.maximizeFromFile("./src/test/resources/input");

        // assert
        assertThat(i).isEqualTo(709);
    }

    @Test
    void part2() {
        // arrange

        // act

        // assert 1626 < 20602 < ? < 112648
        assertThat(true).isFalse();
    }

}
