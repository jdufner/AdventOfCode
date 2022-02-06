package de.jdufner.adventofcode.fifteen;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AoC1514Test {

    @Test
    void whenCalculateCometExpectDistance() {
        // arrange
        AoC1514 aoC1514 = new AoC1514();

        // act
        int distance = aoC1514.calculateDistance(14, 10, 127, 1000);

        // assert
        Assertions.assertThat(distance).isEqualTo(1120);
    }

    @Test
    void whenCalculateDancerExpectDistance() {
        // arrange
        AoC1514 aoC1514 = new AoC1514();

        // act
        int distance = aoC1514.calculateDistance(16, 11, 162, 1000);

        // assert
        Assertions.assertThat(distance).isEqualTo(1056);
    }

    @Test
    void whenMaxDistanceExpectDistance() {
        // arrange
        AoC1514 aoC1514 = new AoC1514();
        List<Reindeer> reindeers = new ArrayList<>();
        reindeers.add(new Reindeer(14, 10, 127));
        reindeers.add(new Reindeer(16, 11, 162));


        // act
        int distance = aoC1514.maxDistance(reindeers, 1000);

        // assert
        Assertions.assertThat(distance).isEqualTo(1120);
    }

    @Test
    void whenMaxBonusExpectBonus() {
        // arrange
        AoC1514 aoC1514 = new AoC1514();
        List<Reindeer> reindeers = new ArrayList<>();
        reindeers.add(new Reindeer(14, 10, 127));
        reindeers.add(new Reindeer(16, 11, 162));

        // act
        int distance = aoC1514.maxBonus(reindeers, 1000);

        // assert
        Assertions.assertThat(distance).isEqualTo(689);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1514 aoC1514 = new AoC1514();

        // act
        int distance = aoC1514.maxDistanceFromFile("./src/test/resources/input", 2503);

        // assert
        Assertions.assertThat(distance).isEqualTo(2640);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1514 aoC1514 = new AoC1514();

        // act
        int distance = aoC1514.maxBonusFromFile("./src/test/resources/input", 2503);

        // assert
        Assertions.assertThat(distance).isEqualTo(1102);
    }

}
