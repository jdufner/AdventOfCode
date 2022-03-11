package de.jdufner.adventofcode.fifteen;

import static de.jdufner.adventofcode.fifteen.AoC1520SinglethreadedPart2.calculateNumberOfPresents;

public class RunnerPart2 implements Runnable {

  private final AoC1520MultithreadedPart2 aoC1520MultithreadedPart2;
  private final int house;
  private final int initialValue;
  private final int stepSize;
  private final int visits;

  private int houseFound = Integer.MAX_VALUE;

  private int myHouse;

  RunnerPart2(AoC1520MultithreadedPart2 aoC1520MultithreadedPart2, int house, int initialValue, int stepSize, int visits) {
    this.aoC1520MultithreadedPart2 = aoC1520MultithreadedPart2;
    this.house = house;
    this.initialValue = initialValue;
    this.stepSize = stepSize;
    this.visits = visits;
  }

  void setHouseFound(int houseFound) {
    this.houseFound = houseFound;
  }

  int getMyHouse() {
    return myHouse;
  }

  @Override
  public void run() {
    int house = findHouseForPresents();
    aoC1520MultithreadedPart2.addHouse(house);
  }

  int findHouseForPresents() {
    int index = initialValue - stepSize;
    int numberPresents = 0;
    while (numberPresents < house && index < houseFound) {
      index += stepSize;
      numberPresents = calculateNumberOfPresents(index, visits);
    }
    myHouse = index;
    return index;
  }

}
