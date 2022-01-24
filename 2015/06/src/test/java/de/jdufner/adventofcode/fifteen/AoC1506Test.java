package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AoC1506Test {

    @Test
    void whenSwitchLightsExpectAllLightsOn() {
        // arrange
        AoC1506 aoC1506 = new AoC1506();

        // act
        aoC1506.switchLights("turn on 0,0 through 999,999");

        // assert
        assertEquals(1000000, aoC1506.countLightsLit());
    }

    @Test
    void whenSwitchLightsExpectThousandsLightsOn() {
        // arrange
        AoC1506 aoC1506 = new AoC1506();

        // act
        aoC1506.switchLights("toggle 0,0 through 999,0");

        // assert
        assertEquals(1000, aoC1506.countLightsLit());
    }

    @Test
    void whenSwitchLightsExpectAllMinusFourLightsOn() {
        // arrange
        AoC1506 aoC1506 = new AoC1506();

        // act
        aoC1506.switchLights("turn on 0,0 through 999,999");
        aoC1506.switchLights("turn off 499,499 through 500,500");

        // assert
        assertEquals(1000000-4, aoC1506.countLightsLit());
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1506 aoC1506 = new AoC1506();

        // act
        aoC1506.switchAllLights("./src/test/resources/input");

        // assert
        assertEquals(569999, aoC1506.countLightsLit());
    }

    @Test
    void part2() throws Exception {
        // arrange

        // act

        // assert
        assertTrue(false);
    }

}
