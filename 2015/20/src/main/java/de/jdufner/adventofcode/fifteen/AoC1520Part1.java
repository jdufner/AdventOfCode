package de.jdufner.adventofcode.fifteen;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class AoC1520Part1 {

  public int findHouseForPresents(int house) {
    int index = (int) sqrt(house/10) - 1;
    index = max(index, 0);
    int sum = 0;
    while (sum < house) {
      index++;
      sum = getSum(index);
    }
    return index;
  }

  int getSum(int index) {
    int sum;
    Set<Integer> factors = getFactors(index);
    sum = factors.stream().mapToInt(i -> i * 10).sum();
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
