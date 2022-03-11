package de.jdufner.adventofcode.fifteen;

import static de.jdufner.adventofcode.fifteen.AoC1520SinglethreadedPart1.calculateNumberOfPresents;

public class RunnerPart1 implements Runnable {

  private final AoC1520MultithreadedPart1 aoC1520MultithreadedPart1;
  private final int house;
  private final int initialValue;
  private final int stepSize;

  private int houseFound = Integer.MAX_VALUE;

  private int myHouse;

  RunnerPart1(AoC1520MultithreadedPart1 aoC1520MultithreadedPart1, int house, int initialValue, int stepSize) {
    this.aoC1520MultithreadedPart1 = aoC1520MultithreadedPart1;
    this.house = house;
    this.initialValue = initialValue;
    this.stepSize = stepSize;
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
    aoC1520MultithreadedPart1.addHouse(house);
  }

  int findHouseForPresents() {
    int index = initialValue - stepSize;
    int numberPresents = 0;
    while (numberPresents < house && index < houseFound) {
      index += stepSize;
      numberPresents = calculateNumberOfPresents(index);
    }
    myHouse = index;
    return index;
  }

}
