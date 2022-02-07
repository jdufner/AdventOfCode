package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AoC1515Test {

    @Test
    void whenCalculateScoreExpectGivenScore() {
        // arrange
        AoC1515 aoC1515 = new AoC1515();
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient butterscotch = new Ingredient("Butterscotch", -1, -2, 6, 3, 8);
        butterscotch.setNumberOfTeaspoons(44);
        ingredients.add(butterscotch);
        Ingredient cinnamon = new Ingredient("Cinnamon", 2, 3, -2, -1, 3);
        cinnamon.setNumberOfTeaspoons(56);
        ingredients.add(cinnamon);

        // act
        int score = aoC1515.calculateScore(ingredients, 100);

        // assert
        assertThat(score).isEqualTo(62842880);
    }

    @Test
    void whenCalculateExampleExpectGivenScore() throws IOException {
        // arrange
        AoC1515 aoC1515 = new AoC1515();

        // act
        int score = aoC1515.calculateScore("./src/test/resources/test", 100);

        // assert
        assertThat(score).isEqualTo(62842880);
    }

    @Test
    void whenCalculateExampleConsideringCaloriesExpectGivenScore() throws IOException {
        // arrange
        AoC1515 aoC1515 = new AoC1515();

        // act
        int score = aoC1515.calculateScoreConsideringCalories("./src/test/resources/test", 100, 500);

        // assert
        assertThat(score).isEqualTo(57600000);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1515 aoC1515 = new AoC1515();

        // act
        int score = aoC1515.calculateScore("./src/test/resources/input", 100);

        // assert
        assertThat(score).isEqualTo(222870);
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1515 aoC1515 = new AoC1515();

        // act
        int score = aoC1515.calculateScoreConsideringCalories("./src/test/resources/input", 100, 500);

        // assert
        assertThat(score).isEqualTo(117936);
    }

}
