package de.jdufner.adventofcode.fifteen;

import java.util.HashSet;
import java.util.Set;

public class AoC1520Part2 {

  public int findHouseForPresents(int house, int visits) {
    int index = 0;
    int sum = 0;
    while (sum < house) {
      index++;
      sum = getSum(index, visits);
    }
    return index;
  }

  int getSum(int house, int visits) {
    int sum;
    Set<Integer> factors = getFactors(house);
    sum = factors.stream().filter(i -> i * visits>= house).mapToInt(i -> i * 11).sum();
    return sum;
  }

  private Set<Integer> getFactors(int i) {
    Set<Integer> factors = new HashSet<>();
    int factor = 0;
    while (factor < i) {
      factor += 1;
      if (i % factor == 0) {
        factors.add(factor);
      }
    }
    factors.add(i);
    return factors;
  }
}
