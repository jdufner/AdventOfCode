package de.jdufner.adventofcode.fifteen;

import java.util.Set;

import static de.jdufner.adventofcode.fifteen.AoC1520SinglethreadedPart1.getFactors;

public class AoC1520SinglethreadedPart2 {

  static int calculateNumberOfPresents(int house, int visits) {
    int numberOfPresents;
    Set<Integer> factors = getFactors(house);
    numberOfPresents = factors.stream().filter(i -> i * visits >= house).mapToInt(i -> i * 11).sum();
    return numberOfPresents;
  }

  int findHouseForPresents(int minNumberOfPresents, int visits) {
    int house = 0;
    int calculatedNumberOfPresents = 0;
    while (calculatedNumberOfPresents < minNumberOfPresents) {
      house++;
      calculatedNumberOfPresents = calculateNumberOfPresents(house, visits);
    }
    return house;
  }

}
