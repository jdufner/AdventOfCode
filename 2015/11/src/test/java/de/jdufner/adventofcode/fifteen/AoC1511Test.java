package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1511Test {

    @Test
    void whenContainsThreeLettersInAStraightExpectTrue() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean threeLettersInAStraight = aoC1511.containsThreeLettersInAStraight("abc");

        // assert
        assertThat(threeLettersInAStraight).isTrue();
    }

    @Test
    void whenContainsThreeLettersInAStraightExpectFalse() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean threeLettersInAStraight = aoC1511.containsThreeLettersInAStraight("abd");

        // assert
        assertThat(threeLettersInAStraight).isFalse();
    }

    @Test
    void whenContainsForbiddenChar1ExpectTrue() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean forbiddenChar = aoC1511.containsForbiddenChar("i");

        // assert
        assertThat(forbiddenChar).isTrue();
    }

    @Test
    void whenContainsForbiddenChar2ExpectTrue() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean forbiddenChar = aoC1511.containsForbiddenChar("o");

        // assert
        assertThat(forbiddenChar).isTrue();
    }

    @Test
    void whenContainsForbiddenChar3ExpectTrue() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean forbiddenChar = aoC1511.containsForbiddenChar("l");

        // assert
        assertThat(forbiddenChar).isTrue();
    }

    @Test
    void whenContainsTwoDifferentNonOverlappingPairsOfLettersExpectTrue() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean twoDifferentNonOverlappingPairsOfLetters = aoC1511.containsTwoDifferentNonOverlappingPairsOfLetters("aabb");

        // assert
        assertThat(twoDifferentNonOverlappingPairsOfLetters).isTrue();
    }

    @Test
    void whenIncrementStringExpectNext1() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String b = aoC1511.incrementString("a");

        // assert
        assertThat(b).isEqualTo("b");
    }

    @Test
    void whenIncrementStringExpectNext2() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String b = aoC1511.incrementString("az");

        // assert
        assertThat(b).isEqualTo("ba");
    }

    @Test
    void whenIncrementStringExpectNext3() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String b = aoC1511.incrementString("aaz");

        // assert
        assertThat(b).isEqualTo("aba");
    }

    @Test
    void whenIsValidPasswordExpectTrue1() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean validPassword = aoC1511.isValidPassword("hijklmmn");

        // assert
        assertThat(validPassword).isFalse();
    }

    @Test
    void whenIsValidPasswordExpectTrue2() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean validPassword = aoC1511.isValidPassword("abbceffg");

        // assert
        assertThat(validPassword).isFalse();
    }

    @Test
    void whenIsValidPasswordExpectTrue3() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        boolean validPassword = aoC1511.isValidPassword("abbcegjk");

        // assert
        assertThat(validPassword).isFalse();
    }

    @Test
    void whenGetNextValidPasswortExpectGiven1() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String nextValidPassword = aoC1511.getNextValidPassword("abcdefgh");

        // assert
        assertThat(nextValidPassword).isEqualTo("abcdffaa");
    }

    @Test
    void whenGetNextValidPasswortExpectGiven2() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String nextValidPassword = aoC1511.getNextValidPassword("ghijklmn");

        // assert
        assertThat(nextValidPassword).isEqualTo("ghjaabcc");
    }

    @Test
    void part1() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String nextValidPassword = aoC1511.getNextValidPassword("hxbxwxba");

        // assert
        assertThat(nextValidPassword).isEqualTo("hxbxxyzz");
    }

    @Test
    void part2() {
        // arrange
        AoC1511 aoC1511 = new AoC1511();

        // act
        String nextValidPassword = aoC1511.getNextValidPassword("hxbxxyzz");

        // assert
        assertThat(nextValidPassword).isEqualTo("hxcaabcc");
    }

}
