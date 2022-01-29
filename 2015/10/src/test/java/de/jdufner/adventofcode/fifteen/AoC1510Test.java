package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1510Test {

    @Test
    void test1() {
        // arrange

        // act
        String s = AoC1510.lookAndSay("1");

        // assert
        assertThat(s).isEqualTo("11");
    }

    @Test
    void test2() {
        // arrange

        // act
        String s = AoC1510.lookAndSay("11");

        // assert
        assertThat(s).isEqualTo("21");
    }

    @Test
    void test3() {
        // arrange

        // act
        String s = AoC1510.lookAndSay("21");

        // assert
        assertThat(s).isEqualTo("1211");
    }

    @Test
    void test4() {
        // arrange

        // act
        String s = AoC1510.lookAndSay("1211");

        // assert
        assertThat(s).isEqualTo("111221");
    }

    @Test
    void test5() {
        // arrange

        // act
        String s = AoC1510.lookAndSay("111221");

        // assert
        assertThat(s).isEqualTo("312211");
    }

    @Test
    void test6() {
        // arrange

        // act
        String s = AoC1510.lookAndSayIteratively("1", 5);

        // assert
        assertThat(s).isEqualTo("312211");
    }

    @Test
    void test7() {
        // arrange

        // act
        String s = AoC1510.lookAndSayIteratively("1321131112", 1);

        // assert
        assertThat(s).isEqualTo("11131221133112");
    }

    @Test
    void test8() {
        // arrange

        // act
        String s = AoC1510.lookAndSayIteratively("1321131112", 2);

        // assert
        assertThat(s).isEqualTo("3113112221232112");
    }

    @Test
    void part1() {
        // arrange

        // act
        int i = AoC1510.lookAndSayIterativelyLength("1321131112", 40);

        // assert
        assertThat(i).isEqualTo(492982);
    }

    @Test
    void part2() {
        // arrange

        // act
        int i = AoC1510.lookAndSayIterativelyLength("1321131112", 50);

        // assert
        assertThat(i).isEqualTo(6989950);
    }

}
