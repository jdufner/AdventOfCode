package de.jdufner.adventofcode.fifteen;

class Ingredient {

    private final String name;

    private final int capacity;
    private final int durability;
    private final int flavor;
    private final int texture;
    private final int calories;
    private int teaspoons;

    Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.name = name;
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
    }

    private static int minZero(int value) {
        if (value < 0) {
            return 0;
        }
        return value;
    }

    String getName() {
        return name;
    }

    int calculateCapacityMultiplyByTeaspoons() {
        return minZero(capacity * teaspoons);
    }

    int calculateDurabilityMultiplyByTeaspoons() {
        return minZero(durability * teaspoons);
    }

    int calculateFlavorMultiplyByTeaspoons() {
        return minZero(flavor * teaspoons);
    }

    int calculateTextureMultiplyByTeaspoons() {
        return minZero(texture * teaspoons);
    }

    int getCalories() {
        return calories;
    }

    public int getNumberOfTeaspoons() {
        return teaspoons;
    }

    Ingredient copy() {
        Ingredient i = new Ingredient(name, capacity, durability, flavor, texture, calories);
        i.teaspoons = teaspoons;
        return i;
    }

    Ingredient incrementAndCopy() {
        Ingredient i = new Ingredient(name, capacity, durability, flavor, texture, calories);
        i.teaspoons = teaspoons + 1;
        return i;
    }

    void increment() {
        teaspoons += 1;
    }

    void resetNumberOfTeaspoons() {
        teaspoons = 0;
    }
}
