package de.jdufner.adventofcode.fifteen;

class Character {

  private int hitpoints;
  private final Item.Weapon weapon;
  private final Item.Armor armor;
  private final Item.Ring ring1;
  private final Item.Ring ring2;

  Character(int hitpoints, Item.Weapon weapon, Item.Armor armor, Item.Ring ring1, Item.Ring ring2) {
    this.hitpoints = hitpoints;
    this.weapon = weapon;
    this.armor = armor;
    this.ring1 = ring1;
    this.ring2 = ring2;
  }

  int getHitpoints() {
    return hitpoints;
  }

  void setHitpoints(int hitpoints) {
    this.hitpoints = hitpoints;
  }

  int getArmor() {
    return weapon.getArmor() + armor.getArmor() + ring1.getArmor() + ring2.getArmor();
  }

  int getDamage() {
    return weapon.getDamage() + armor.getDamage() + ring1.getDamage() + ring2.getDamage();
  }

  boolean hasInvalidRingCombo() {
    return !(ring1 != ring2 || (ring1.getPrice() == 0 && ring1.getDamage() == 0 && ring1.getArmor() == 0));
  }

  int getCosts() {
    return weapon.getPrice() + armor.getPrice() + ring1.getPrice() + ring2.getPrice();
  }

  public Character getClone() {
    return new Character(hitpoints, weapon, armor, ring1, ring2);
  }

}
