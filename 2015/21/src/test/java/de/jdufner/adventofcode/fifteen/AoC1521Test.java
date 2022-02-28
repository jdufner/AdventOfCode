package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1521Test {

  @Test
  void part1() {
    // arrange
    AoC1521 aoC1521 = new AoC1521();

    // act
    int minCosts = aoC1521.getMinCostsAndWin();

    // assert
    assertThat(minCosts).isEqualTo(121);
  }

  @Test
  void part2() {
    // arrange
    AoC1521 aoC1521 = new AoC1521();

    // act
    int minCosts = aoC1521.getMaxCostsAndLose();

    // assert
    assertThat(minCosts).isEqualTo(201);
  }

}
