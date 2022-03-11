package de.jdufner.adventofcode.fifteen;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;
import static java.lang.Thread.sleep;

class AoC1520MultithreadedPart1 {

  final ThreadGroup threadGroup = new ThreadGroup("cores");
  final List<RunnerPart1> runnerPart1s = new ArrayList<>();

  void findHouseForPresents(int house) {
    int cores = Runtime.getRuntime().availableProcessors();
    for (int i = 0; i < cores; i++) {
      RunnerPart1 r = new RunnerPart1(this, house, i + 1, cores);
      runnerPart1s.add(r);
      Thread t = new Thread(threadGroup, r);
      t.start();
    }
  }

  synchronized void addHouse(int house) {
    for (RunnerPart1 r : runnerPart1s) {
      r.setHouseFound(house);
    }
  }

  int getHouse() throws InterruptedException {
    while (threadGroup.activeCount() > 0) {
      sleep(100);
    }
    int house = Integer.MAX_VALUE;
    for (RunnerPart1 r : runnerPart1s) {
      house = min(r.getMyHouse(), house);
    }
    return house;
  }

}
