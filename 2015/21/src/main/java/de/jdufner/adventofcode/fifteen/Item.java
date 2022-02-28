package de.jdufner.adventofcode.fifteen;

class Item {

  private final int price;
  private final int damage;
  private final int armor;

  Item(int price, int damage, int armor) {
    this.price = price;
    this.damage = damage;
    this.armor = armor;
  }

  int getPrice() {
    return price;
  }

  int getDamage() {
    return damage;
  }

  int getArmor() {
    return armor;
  }

  static class Weapon extends Item {
    Weapon(int price, int damage, int armor) {
      super(price, damage, armor);
    }
  }

  static class Armor extends Item {
    public Armor(int price, int damage, int armor) {
      super(price, damage, armor);
    }
  }

  static class Ring extends Item {
    public Ring(int price, int damage, int armor) {
      super(price, damage, armor);
    }
  }

}
