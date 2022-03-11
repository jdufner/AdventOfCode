package de.jdufner.adventofcode.fifteen;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class AoC1520SinglethreadedPart1 {

  static Set<Integer> getFactors(int index) {
    Set<Integer> factors = new HashSet<>();
    int factor = 0;
    while (factor < index) {
      factor += 1;
      if (index % factor == 0) {
        factors.add(factor);
      }
    }
    factors.add(index);
    return factors;
  }

  static int calculateNumberOfPresents(int house) {
    int sum;
    Set<Integer> factors = getFactors(house);
    sum = factors.stream().mapToInt(i -> i * 10).sum();
    return sum;
  }

  int findHouseForPresents(int minNumberPresents) {
    int house = optimizeStartHouse(minNumberPresents);
    int calculatesNumberOfPresents = 0;
    while (calculatesNumberOfPresents < minNumberPresents) {
      house++;
      calculatesNumberOfPresents = calculateNumberOfPresents(house);
    }
    return house;
  }

  private int optimizeStartHouse(int minNumberPresents) {
    int house = (int) sqrt(minNumberPresents / 10) - 1;
    house = max(house, 0);
    return house;
  }

}
