package de.jdufner.adventofcode.fifteen;

import static java.lang.Math.max;
import static java.lang.Math.min;

class AoC1521 {

  static Item.Weapon[] weapons = new Item.Weapon[]{
      new Item.Weapon(8, 4, 0),
      new Item.Weapon(10, 5, 0),
      new Item.Weapon(25, 6, 0),
      new Item.Weapon(40, 7, 0),
      new Item.Weapon(74, 8, 0)
  };

  static Item.Armor[] armors = new Item.Armor[]{
      new Item.Armor(0,0,0),
      new Item.Armor(13, 0, 1),
      new Item.Armor(31, 0,2),
      new Item.Armor(53, 0, 3),
      new Item.Armor(75, 0, 4),
      new Item.Armor(102, 0, 5)
  };

  static Item.Ring[] rings = new Item.Ring[]{
      new Item.Ring(0, 0, 0),
      new Item.Ring(25, 1, 0),
      new Item.Ring(50, 2, 0),
      new Item.Ring(100, 3, 0),
      new Item.Ring(20, 0, 1),
      new Item.Ring(40, 0, 2),
      new Item.Ring(80, 0, 3)
  };

  static Character boss = new Character(103,
      new Item.Weapon(0, 9,0),
      new Item.Armor(0, 0, 2),
      new Item.Ring(0,0,0),
      new Item.Ring(0,0,0));

  int getMinCostsAndWin() {
    int costs = Integer.MAX_VALUE;
    for (Item.Weapon weapon: weapons) {
      for (Item.Armor armor: armors) {
        for (Item.Ring ring1: rings) {
          for (Item.Ring ring2: rings) {
            Character player = new Character(100, weapon, armor, ring1, ring2);
            if (player.hasInvalidRingCombo()) {
              continue;
            }
            if (playerWins(player, boss.getClone())) {
              costs = min(costs, player.getCosts());
            }
          }
        }
      }
    }
    return costs;
  }

  int getMaxCostsAndLose() {
    int costs = 0;
    for (Item.Weapon weapon: weapons) {
      for (Item.Armor armor: armors) {
        for (Item.Ring ring1: rings) {
          for (Item.Ring ring2: rings) {
            Character player = new Character(100, weapon, armor, ring1, ring2);
            if (player.hasInvalidRingCombo()) {
              continue;
            }
            if (!playerWins(player, boss.getClone())) {
              costs = max(costs, player.getCosts());
            }
          }
        }
      }
    }
    return costs;
  }

  private boolean playerWins(Character player, Character boss) {
    while (player.getHitpoints() > 0 && boss.getHitpoints() > 0) {
      boss.setHitpoints(boss.getHitpoints() - player.getDamage() + boss.getArmor());
      if (boss.getHitpoints() <= 0) return true;
      player.setHitpoints(player.getHitpoints() - boss.getDamage() + player.getArmor());
      if (player.getHitpoints() <= 0) return false;
    }
    return false;
  }

}
