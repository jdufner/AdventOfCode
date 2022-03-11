package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1520MultithreadedTest {

  @Test
  void when10PresentsExpectHouse1() throws Exception {
    // arrange
    AoC1520MultithreadedPart1 aoC1520MultithreadedPart1 = new AoC1520MultithreadedPart1();

    // act
    aoC1520MultithreadedPart1.findHouseForPresents(10);
    int house = aoC1520MultithreadedPart1.getHouse();

    // assert
    assertThat(house).isEqualTo(1);
  }

  @Test
  void when30PresentsExpectHouse2() throws Exception {
    // arrange
    AoC1520MultithreadedPart1 aoC1520MultithreadedPart1 = new AoC1520MultithreadedPart1();

    // act
    aoC1520MultithreadedPart1.findHouseForPresents(30);
    int house = aoC1520MultithreadedPart1.getHouse();

    // assert
    assertThat(house).isEqualTo(2);
  }

  @Test
  void when40PresentsExpectHouse3() throws Exception {
    // arrange
    AoC1520MultithreadedPart1 aoC1520MultithreadedPart1 = new AoC1520MultithreadedPart1();

    // act
    aoC1520MultithreadedPart1.findHouseForPresents(40);
    int house = aoC1520MultithreadedPart1.getHouse();

    // assert
    assertThat(house).isEqualTo(3);
  }

  @Test
  void part1() throws Exception {
    // arrange
    AoC1520MultithreadedPart1 aoC1520MultithreadedPart1 = new AoC1520MultithreadedPart1();

    // act
    aoC1520MultithreadedPart1.findHouseForPresents(33_100_000);
    int house = aoC1520MultithreadedPart1.getHouse();

    // assert
    assertThat(house).isEqualTo(776_160);
  }

  @Test
  void part2() throws Exception {
    // arrange
    AoC1520MultithreadedPart2 aoC1520MultithreadedPart2 = new AoC1520MultithreadedPart2();

    // act
    aoC1520MultithreadedPart2.findHouseForPresents(33_100_000, 50);
    int house = aoC1520MultithreadedPart2.getHouse();

        // assert
    assertThat(house).isEqualTo(786_240);
  }

}
