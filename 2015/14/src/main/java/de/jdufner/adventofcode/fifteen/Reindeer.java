package de.jdufner.adventofcode.fifteen;

import static de.jdufner.adventofcode.fifteen.Reindeer.Phase.Perseverance;
import static de.jdufner.adventofcode.fifteen.Reindeer.Phase.Rest;

class Reindeer {


    enum Phase {Perseverance, Rest}

    private final int speed;

    private final int perseverance;
    private final int rest;

    private int distance = 0;
    private int remainingTime = 0;

    private Phase phase = Perseverance;
    private int points = 0;
    Reindeer(int speed, int perseverance, int rest) {
        this.speed = speed;
        this.perseverance = perseverance;
        this.rest = rest;
        remainingTime = perseverance;
    }

    int getSpeed() {
        return speed;
    }

    int getPerseverance() {
        return perseverance;
    }

    int getRest() {
        return rest;
    }

    int getDistance() {
        return distance;
    }

    void increasePoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public void tick(int second) {
        remainingTime--;
        if (phase == Perseverance) {
           distance += speed;
           if (remainingTime == 0) {
               phase = Rest;
               remainingTime = rest;
           }
        }
        if (phase == Rest) {
            if (remainingTime == 0) {
                phase = Perseverance;
                remainingTime = perseverance;
            }
        }
    }

}
