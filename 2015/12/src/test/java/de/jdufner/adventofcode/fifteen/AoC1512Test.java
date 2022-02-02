package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1512Test {

    @Test
    void whenSumExpect1() {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigits("[1,2,3]");

        // assert
        assertThat(sumDigits).isEqualTo(6);
    }

    @Test
    void whenSumExpect2() {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigits("{\"a\":2,\"b\":4}");

        // assert
        assertThat(sumDigits).isEqualTo(6);
    }

    @Test
    void whenSumExpect3() {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigits("[[[3]]]");

        // assert
        assertThat(sumDigits).isEqualTo(3);
    }

    @Test
    void whenSumExpect4() {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigits("{\"a\":{\"b\":4},\"c\":-1}");

        // assert
        assertThat(sumDigits).isEqualTo(3);
    }

    @Test
    void whenSumExpect5() {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigits("{\"a\":[-1,1]}");

        // assert
        assertThat(sumDigits).isEqualTo(0);
    }

    @Test
    void whenSumExpect6() {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigits("[-1,{\"a\":1}]");

        // assert
        assertThat(sumDigits).isEqualTo(0);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigitsFromFile("./src/test/resources/input");

        // assert
        assertThat(sumDigits).isEqualTo(119433);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1512 aoC1512 = new AoC1512();

        // act
        int sumDigits = aoC1512.sumDigitsWithoutRedObjectsFromFile("./src/test/resources/input");

        // assert 1626 < 20602 < ? < 112648
        assertThat(sumDigits).isEqualTo(68466);
    }

}
