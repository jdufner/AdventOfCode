package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1520Test {

  @Test
  void whenHouse1Expect10Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(1);

    // assert
    assertThat(presents).isEqualTo(10);
  }

  @Test
  void whenHouse2Expect30Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(2);

    // assert
    assertThat(presents).isEqualTo(30);
  }

  @Test
  void whenHouse3Expect40Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(3);

    // assert
    assertThat(presents).isEqualTo(40);
  }

  @Test
  void whenHouse4Expect70Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(4);

    // assert
    assertThat(presents).isEqualTo(70);
  }

  @Test
  void whenHouse5Expect60Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(5);

    // assert
    assertThat(presents).isEqualTo(60);
  }

  @Test
  void whenHouse6Expect120Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(6);

    // assert
    assertThat(presents).isEqualTo(120);
  }

  @Test
  void whenHouse7Expect80Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(7);

    // assert
    assertThat(presents).isEqualTo(80);
  }

  @Test
  void whenHouse8Expect150Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(8);

    // assert
    assertThat(presents).isEqualTo(150);
  }

  @Test
  void whenHouse9Expect130Presents() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int presents = aoC1520Part1.getSum(9);

    // assert
    assertThat(presents).isEqualTo(130);
  }

  @Test
  void when10PresentsExpectHouse1() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int house = aoC1520Part1.findHouseForPresents(10);

    // assert
    assertThat(house).isEqualTo(1);
  }

  @Test
  void when30PresentsExpectHouse2() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int house = aoC1520Part1.findHouseForPresents(30);

    // assert
    assertThat(house).isEqualTo(2);
  }

  @Test
  void when40PresentsExpectHouse3() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int house = aoC1520Part1.findHouseForPresents(40);

    // assert
    assertThat(house).isEqualTo(3);
  }

  @Test
  void whenHouse1Expect11Presents() {
    // arrange
    AoC1520Part2 aoC1520Part2 = new AoC1520Part2();

    // act
    int presents = aoC1520Part2.getSum(1, 1);

    // assert
    assertThat(presents).isEqualTo(11);
  }

  @Test
  void whenHouse2Expect33Presents() {
    // arrange
    AoC1520Part2 aoC1520Part2 = new AoC1520Part2();

    // act
    int presents = aoC1520Part2.getSum(2, 2);

    // assert
    assertThat(presents).isEqualTo(33);
  }

  @Test
  void whenHouse9Expect99Presents() {
    // arrange
    AoC1520Part2 aoC1520Part2 = new AoC1520Part2();

    // act
    int presents = aoC1520Part2.getSum(9, 2);

    // assert
    assertThat(presents).isEqualTo(99);
  }

  @Test
  void whenHouse9Expect132Presents() {
    // arrange
    AoC1520Part2 aoC1520Part2 = new AoC1520Part2();

    // act
    int presents = aoC1520Part2.getSum(9, 3);

    // assert
    assertThat(presents).isEqualTo(132);
  }

  @Test
  @Disabled
  void part1() {
    // arrange
    AoC1520Part1 aoC1520Part1 = new AoC1520Part1();

    // act
    int house = aoC1520Part1.findHouseForPresents(33_100_000);

    // assert
    assertThat(house).isEqualTo(776_160);
  }

  @Test
  @Disabled
  void part2() {
    // arrange
    AoC1520Part2 aoC1520Part2 = new AoC1520Part2();

    // act
    int house = aoC1520Part2.findHouseForPresents(33_100_000, 50);

    // assert
    assertThat(house).isEqualTo(786_240);
  }

}
