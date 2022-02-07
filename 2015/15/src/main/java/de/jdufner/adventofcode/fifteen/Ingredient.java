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

    String getName() {
        return name;
    }

    int calculateCapacityMultiplyByTeaspoons() {
        return capacity * teaspoons;
    }

    int calculateDurabilityMultiplyByTeaspoons() {
        return durability * teaspoons;
    }

    int calculateFlavorMultiplyByTeaspoons() {
        return flavor * teaspoons;
    }

    int calculateTextureMultiplyByTeaspoons() {
        return texture * teaspoons;
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

    void setNumberOfTeaspoons(int teaspoons) {
        this.teaspoons = teaspoons;
    }
}
