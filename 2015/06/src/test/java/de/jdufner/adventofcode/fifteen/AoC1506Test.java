package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AoC1506Test {

    @Test
    void whenSwitchLightsExpectAllLightsOn() {
        // arrange
        AoC1506Part1 aoC1506Part1 = new AoC1506Part1();

        // act
        aoC1506Part1.switchLights("turn on 0,0 through 999,999");

        // assert
        assertEquals(1000000, aoC1506Part1.countLightsLit());
    }

    @Test
    void whenSwitchLightsExpectThousandsLightsOn() {
        // arrange
        AoC1506Part1 aoC1506Part1 = new AoC1506Part1();

        // act
        aoC1506Part1.switchLights("toggle 0,0 through 999,0");

        // assert
        assertEquals(1000, aoC1506Part1.countLightsLit());
    }

    @Test
    void whenSwitchLightsExpectAllMinusFourLightsOn() {
        // arrange
        AoC1506Part1 aoC1506Part1 = new AoC1506Part1();

        // act
        aoC1506Part1.switchLights("turn on 0,0 through 999,999");
        aoC1506Part1.switchLights("turn off 499,499 through 500,500");

        // assert
        assertEquals(1000000-4, aoC1506Part1.countLightsLit());
    }

    @Test
    void whenSwitchLightsExpectOne() {
        // arrange
        AoC1506Part2 aoC1506Part2 = new AoC1506Part2();

        // act
        aoC1506Part2.switchLights("turn on 0,0 through 0,0");

        // assert
        assertEquals(1, aoC1506Part2.sumLightsLit());
    }

    @Test
    void whenSwitchLightsExpectTwoMillions() {
        // arrange
        AoC1506Part2 aoC1506Part2 = new AoC1506Part2();

        // act
        aoC1506Part2.switchLights("toggle 0,0 through 999,999");

        // assert
        assertEquals(2000000, aoC1506Part2.sumLightsLit());
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1506Part1 aoC1506Part1 = new AoC1506Part1();

        // act
        aoC1506Part1.switchAllLights("./src/test/resources/input");

        // assert
        assertEquals(569999, aoC1506Part1.countLightsLit());
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1506Part2 aoC1506Part2 = new AoC1506Part2();

        // act
        aoC1506Part2.switchAllLights("./src/test/resources/input");

        // assert
        assertEquals(17836115, aoC1506Part2.sumLightsLit());
    }

}
