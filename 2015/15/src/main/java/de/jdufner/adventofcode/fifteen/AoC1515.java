package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class AoC1515 {

    private static final Pattern LINE_PATTERN = Pattern.compile("(\\w+): capacity (-?\\d+), durability (-?\\d+), flavor (-?\\d+), texture (-?\\d+), calories (-?\\d+)");

    private final List<Ingredient> ingredients = new ArrayList<>();

    private int maxScore = 0;

    private static int minZero(int value) {
        return Math.max(0, value);
    }

    int calculateScore(String filename, int sumOfTeaspoons) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        return optimizeIngredients(ingredients, 0, sumOfTeaspoons);
    }

    int calculateScoreConsideringCalories(String filename, int sumOfTeaspoons, int sumOfCalories) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseString);
        }
        return optimizeIngredientsConsideringCalories(ingredients, 0, sumOfTeaspoons, sumOfCalories);
    }

    private int optimizeIngredients(List<Ingredient> ingredients, int indexOfIngredient, int sumOfTeaspoons) {
        for (int i = 0; i <= sumOfTeaspoons; i++) {
            ingredients.get(indexOfIngredient).setNumberOfTeaspoons(i);
            if (indexOfIngredient < ingredients.size() - 1) {
                List<Ingredient> newIngredients = new ArrayList<>();
                for (Ingredient ingredient : ingredients) {
                    newIngredients.add(ingredient.copy());
                }
                optimizeIngredients(newIngredients, indexOfIngredient + 1, sumOfTeaspoons);
            } else {
                int score = calculateScore(ingredients, sumOfTeaspoons);
                if (score > maxScore) {
//                    buildString(ingredients, score);
                    maxScore = score;
                }
            }
        }
        return maxScore;
    }

    private int optimizeIngredientsConsideringCalories(List<Ingredient> ingredients, int indexOfIngredient, int sumOfTeaspoons, int sumOfCalories) {
        for (int i = 0; i <= sumOfTeaspoons; i++) {
            ingredients.get(indexOfIngredient).setNumberOfTeaspoons(i);
            if (indexOfIngredient < ingredients.size() - 1) {
                List<Ingredient> newIngredients = new ArrayList<>();
                for (Ingredient ingredient : ingredients) {
                    newIngredients.add(ingredient.copy());
                }
                optimizeIngredientsConsideringCalories(newIngredients, indexOfIngredient + 1, sumOfTeaspoons, sumOfCalories);
            } else {
                int score = calculateScore(ingredients, sumOfTeaspoons);
                int calories = calculateCalories(ingredients);
                if (score > maxScore && calories == sumOfCalories) {
//                    buildString(ingredients, score);
                    maxScore = score;
                }
            }
        }
        return maxScore;
    }

    private void buildString(List<Ingredient> ingredients, int score) {
        StringBuilder sb = new StringBuilder();
        for (Ingredient ingredient: ingredients) {
            sb.append(ingredient.getName());
            sb.append(": ");
            sb.append(ingredient.getNumberOfTeaspoons());
            sb.append(", ");
        }
        System.out.println(sb + " -> " + score);
    }

    private void parseString(String line) {
        Matcher matcher = LINE_PATTERN.matcher(line);
        if (matcher.matches()) {
            ingredients.add(new Ingredient(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6))));
        }
    }

    int calculateScore(List<Ingredient> ingredients, int sumOfTeaspoons) {
        if (sumOfTeaspoons(ingredients) == sumOfTeaspoons) {
            return minZero(ingredients.stream().mapToInt(this::calculateCapacity).sum()) *
                    minZero(ingredients.stream().mapToInt(this::calculateDurability).sum()) *
                    minZero(ingredients.stream().mapToInt(this::calculateFlavor).sum()) *
                    minZero(ingredients.stream().mapToInt(this::calculateTexture).sum());
        }
        return 0;
    }

    int calculateCalories(List<Ingredient> ingredients) {
        return minZero(ingredients.stream().mapToInt(this::calculateCalories).sum());
    }

    private int calculateCalories(Ingredient ingredient) {
        return ingredient.getCaloriesMultiplyByTeaspoons();
    }

    private int sumOfTeaspoons(List<Ingredient> ingredients) {
        return ingredients.stream().mapToInt(this::getNumberOfTeaspoons).sum();
    }

    private int getNumberOfTeaspoons(Ingredient ingredient) {
        return ingredient.getNumberOfTeaspoons();
    }

    private int calculateTexture(Ingredient ingredient) {
        return ingredient.calculateTextureMultiplyByTeaspoons();
    }

    private int calculateFlavor(Ingredient ingredient) {
        return ingredient.calculateFlavorMultiplyByTeaspoons();
    }

    private int calculateDurability(Ingredient ingredient) {
        return ingredient.calculateDurabilityMultiplyByTeaspoons();
    }

    private int calculateCapacity(Ingredient ingredient) {
        return ingredient.calculateCapacityMultiplyByTeaspoons();
    }

}
