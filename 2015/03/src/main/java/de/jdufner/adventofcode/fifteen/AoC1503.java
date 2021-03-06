package de.jdufner.adventofcode.fifteen;

import java.nio.charset.StandardCharsets;

class AoC1503 {

    static int walk(String s) {
        House h = new House(0, 0);

        int index = 0;
        byte[] chars = s.getBytes(StandardCharsets.UTF_8);
        while (index < chars.length) {
            h = h.move(chars[index]);
            index++;
        }

        return House.getNumberAllHouses();
    }

    static int walkSantaAndRoboSanta(String s) {
        House santa = new House(0, 0);
        House roboSanta = new House(0, 0);

        int index = 0;
        byte[] chars = s.getBytes(StandardCharsets.UTF_8);
        while (index < chars.length) {
            if (index % 2 == 0) {
                santa = santa.move(chars[index]);
            } else {
                roboSanta = roboSanta.move(chars[index]);
            }
            index++;
        }

        return House.getNumberAllHouses();
    }

}
