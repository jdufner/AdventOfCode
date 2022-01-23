package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseTest {

    @Test
    void testWhenCreateHouseExpectInAllHouses() {
        // arrange
        House.reset();

        // act
        House house = new House(0, 0);

        // assert
        assertEquals(1, House.getNumberAllHouses());
    }

    @Test
    void testWhenVisitHouseExpectInAllVisits() {
        // arrange
        House.reset();

        // act
        House house = new House(0, 0);

        // assert
        assertEquals(1, House.getNumberAllHouses());
    }

    @Test
    void testWhenGoToTopHouseExpectTop() {
        // arrange
        House.reset();

        // act
        House house1 = new House(0, 0);
        House house2 = house1.top();

        // assert
        assertEquals(2, House.getNumberAllHouses());
    }

    @Test
    void testWhenGoToTopAndBottomHouseExpectHome() {
        // arrange
        House.reset();

        // act
        House house1 = new House(0, 0);
        House house2 = house1.top();
        house2.bottom();

        // assert
        assertEquals(2, House.getNumberAllHouses());
    }

    @Test
    void testWhenGoToRightAndLeftHouseExpectHome() {
        // arrange
        House.reset();

        // act
        House house1 = new House(0, 0);
        House house2 = house1.right();
        house2.left();

        // assert
        assertEquals(2, House.getNumberAllHouses());
    }

    @Test
    void testWhenGoToBottomAndTopHouseExpectHome() {
        // arrange
        House.reset();

        // act
        House house1 = new House(0, 0);
        House house2 = house1.bottom();
        house2.top();

        // assert
        assertEquals(2, House.getNumberAllHouses());
    }

    @Test
    void testWhenGoToLeftAndRightHouseExpectHome() {
        // arrange
        House.reset();

        // act
        House house1 = new House(0, 0);
        House house2 = house1.left();
        house2.right();

        // assert
        assertEquals(2, House.getNumberAllHouses());
    }

}