package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1509Test {

    @Test
    void whenBuildPathBetweenTwoLocationsFromExampleExpect3Instances() {
        // arrange
        PathBetweenTwoLocations.resetLocations();
        AoC1509 aoC1509 = new AoC1509();

        // act
        aoC1509.buildPathBetweenTwoLocations("London to Dublin = 464");
        aoC1509.buildPathBetweenTwoLocations("London to Belfast = 518");
        aoC1509.buildPathBetweenTwoLocations("Dublin to Belfast = 141");

        // assert
        assertThat(aoC1509.getPathBetweenTwoLocations()).hasSize(3);
    }

    @Test
    void whenFindShortestPathExpectShortest() {
        // arrange
        PathBetweenTwoLocations.resetLocations();
        AoC1509 aoC1509 = new AoC1509();
        aoC1509.buildPathBetweenTwoLocations("London to Dublin = 464");
        aoC1509.buildPathBetweenTwoLocations("London to Belfast = 518");
        aoC1509.buildPathBetweenTwoLocations("Dublin to Belfast = 141");

        // act
        aoC1509.findShortestPath(new ArrayList<String>(), PathBetweenTwoLocations.getLocations(), 0);

        // assert
        assertThat(aoC1509.getSmallestCompletePath()).isEqualTo(605);
    }

    @Test
    void part1() throws Exception {
        // arrange
        PathBetweenTwoLocations.resetLocations();
        AoC1509 aoC1509 = new AoC1509();
        aoC1509.loadLocations("./src/test/resources/input");

        // act
        aoC1509.findShortestPath(new ArrayList<String>(), PathBetweenTwoLocations.getLocations(), 0);

        // assert
        assertThat(aoC1509.getSmallestCompletePath()).isEqualTo(141);
    }

    @Test
    void part2() throws Exception {
        // arrange
        PathBetweenTwoLocations.resetLocations();
        AoC1509 aoC1509 = new AoC1509();
        aoC1509.loadLocations("./src/test/resources/input");

        // act
        aoC1509.findShortestPath(new ArrayList<String>(), PathBetweenTwoLocations.getLocations(), 0);

        // assert
        assertThat(aoC1509.getLargestCompletePath()).isEqualTo(736);
    }

}
