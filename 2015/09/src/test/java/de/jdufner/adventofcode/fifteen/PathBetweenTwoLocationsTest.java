package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PathBetweenTwoLocationsTest {

    @Test
    void whenConstructExpectStringParsed() {
        // arrange

        // act
        PathBetweenTwoLocations pathBetweenTwoLocations = new PathBetweenTwoLocations("London to Dublin = 464");

        // assert
        assertEquals("London", pathBetweenTwoLocations.getFromLocation());
        assertEquals("Dublin", pathBetweenTwoLocations.getToLocation());
        assertEquals(464, pathBetweenTwoLocations.getDistance());
        assertThat(PathBetweenTwoLocations.getLocations()).contains("London", "Dublin");
    }

    @Test
    void whenPathBetweenTwoLocationsAreLocationsExpectChecked() {
        // arrange
        PathBetweenTwoLocations pathBetweenTwoLocations = new PathBetweenTwoLocations("London to Dublin = 464");

        // act

        // assert
        assertThat(pathBetweenTwoLocations.areLocations("London", "Dublin")).isTrue();
        assertThat(pathBetweenTwoLocations.areLocations("London", "Belfast")).isFalse();
    }

    @Test
    void whenPathBetweenTwoLocationsIsOneOfAllLocationsExpectChecked() {
        // arrange
        PathBetweenTwoLocations pathBetweenTwoLocations = new PathBetweenTwoLocations("London to Dublin = 464");

        // act

        // assert
        assertThat(pathBetweenTwoLocations.isOneOfAllLocations("London")).isTrue();
        assertThat(pathBetweenTwoLocations.isOneOfAllLocations("Belfast")).isFalse();
    }

}
