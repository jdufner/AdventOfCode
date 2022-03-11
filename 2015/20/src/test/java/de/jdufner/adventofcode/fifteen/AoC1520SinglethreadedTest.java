package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static de.jdufner.adventofcode.fifteen.AoC1520SinglethreadedPart1.calculateNumberOfPresents;
import static de.jdufner.adventofcode.fifteen.AoC1520SinglethreadedPart2.calculateNumberOfPresents;
import static org.assertj.core.api.Assertions.assertThat;

class AoC1520SinglethreadedTest {

  @Test
  void whenHouse1Expect10Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(1);

    // assert
    assertThat(presents).isEqualTo(10);
  }

  @Test
  void whenHouse2Expect30Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(2);

    // assert
    assertThat(presents).isEqualTo(30);
  }

  @Test
  void whenHouse3Expect40Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(3);

    // assert
    assertThat(presents).isEqualTo(40);
  }

  @Test
  void whenHouse4Expect70Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(4);

    // assert
    assertThat(presents).isEqualTo(70);
  }

  @Test
  void whenHouse5Expect60Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(5);

    // assert
    assertThat(presents).isEqualTo(60);
  }

  @Test
  void whenHouse6Expect120Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(6);

    // assert
    assertThat(presents).isEqualTo(120);
  }

  @Test
  void whenHouse7Expect80Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(7);

    // assert
    assertThat(presents).isEqualTo(80);
  }

  @Test
  void whenHouse8Expect150Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(8);

    // assert
    assertThat(presents).isEqualTo(150);
  }

  @Test
  void whenHouse9Expect130Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(9);

    // assert
    assertThat(presents).isEqualTo(130);
  }

  @Test
  void when10PresentsExpectHouse1() {
    // arrange
    AoC1520SinglethreadedPart1 aoC1520SinglethreadedPart1 = new AoC1520SinglethreadedPart1();

    // act
    int house = aoC1520SinglethreadedPart1.findHouseForPresents(10);

    // assert
    assertThat(house).isEqualTo(1);
  }

  @Test
  void when30PresentsExpectHouse2() {
    // arrange
    AoC1520SinglethreadedPart1 aoC1520SinglethreadedPart1 = new AoC1520SinglethreadedPart1();

    // act
    int house = aoC1520SinglethreadedPart1.findHouseForPresents(30);

    // assert
    assertThat(house).isEqualTo(2);
  }

  @Test
  void when40PresentsExpectHouse3() {
    // arrange
    AoC1520SinglethreadedPart1 aoC1520SinglethreadedPart1 = new AoC1520SinglethreadedPart1();

    // act
    int house = aoC1520SinglethreadedPart1.findHouseForPresents(40);

    // assert
    assertThat(house).isEqualTo(3);
  }

  @Test
  void whenHouse1Expect11Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(1, 1);

    // assert
    assertThat(presents).isEqualTo(11);
  }

  @Test
  void whenHouse2Expect33Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(2, 2);

    // assert
    assertThat(presents).isEqualTo(33);
  }

  @Test
  void whenHouse9Expect99Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(9, 2);

    // assert
    assertThat(presents).isEqualTo(99);
  }

  @Test
  void whenHouse9Expect132Presents() {
    // arrange

    // act
    int presents = calculateNumberOfPresents(9, 3);

    // assert
    assertThat(presents).isEqualTo(132);
  }

  @Test
  @Disabled
  void part1() {
    // arrange
    AoC1520SinglethreadedPart1 aoC1520SinglethreadedPart1 = new AoC1520SinglethreadedPart1();

    // act
    int house = aoC1520SinglethreadedPart1.findHouseForPresents(33_100_000);

    // assert
    assertThat(house).isEqualTo(776_160);
  }

  @Test
  @Disabled
  void part2() {
    // arrange
    AoC1520SinglethreadedPart2 aoC1520SinglethreadedPart2 = new AoC1520SinglethreadedPart2();

    // act
    int house = aoC1520SinglethreadedPart2.findHouseForPresents(33_100_000, 50);

    // assert
    assertThat(house).isEqualTo(786_240);
  }

}
