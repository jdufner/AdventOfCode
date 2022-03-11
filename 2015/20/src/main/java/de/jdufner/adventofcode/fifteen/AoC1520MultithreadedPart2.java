package de.jdufner.adventofcode.fifteen;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;
import static java.lang.Thread.sleep;

class AoC1520MultithreadedPart2 {

  final ThreadGroup threadGroup = new ThreadGroup("cores");
  final List<RunnerPart2> runnerPart2s = new ArrayList<>();

  void findHouseForPresents(int house, int visits) {
    int cores = Runtime.getRuntime().availableProcessors();
    for (int i = 0; i < cores; i++) {
      RunnerPart2 r = new RunnerPart2(this, house, i + 1, cores, visits);
      runnerPart2s.add(r);
      Thread t = new Thread(threadGroup, r);
      t.start();
    }
  }

  synchronized void addHouse(int house) {
    for (RunnerPart2 r : runnerPart2s) {
      r.setHouseFound(house);
    }
  }

  int getHouse() throws InterruptedException {
    while (threadGroup.activeCount() > 0) {
      sleep(100);
    }
    int house = Integer.MAX_VALUE;
    for (RunnerPart2 r : runnerPart2s) {
      house = min(r.getMyHouse(), house);
    }
    return house;
  }

}
