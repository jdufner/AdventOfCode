package de.jdufner.adventofcode.fifteen;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        Assertions.assertThat(score).isEqualTo(62842880);
    }

    @Test
    void whenCalculateExampleExpectGivenScore() throws IOException {
        // arrange
        AoC1515 aoC1515 = new AoC1515();

        // act
        int score = aoC1515.calculateScore("./src/test/resources/test", 100);

        // assert
        Assertions.assertThat(score).isEqualTo(62842880);
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1515 aoC1515 = new AoC1515();

        // act
        int score = aoC1515.calculateScore("./src/test/resources/input", 100);

        // assert
        Assertions.assertThat(score).isEqualTo(222870);
    }

    @Test
    void part2() throws Exception {
        // arrange

        // act

        // assert
    }

}
