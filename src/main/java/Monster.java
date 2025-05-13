//-------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//-------------------------------------

/**
 * Represents a monster with strength, craft, and health.
 */
public class Monster {
    private final String name;
    private final int strength;
    private final int craft;
    private int health;

    public Monster(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getCraft() {
        return craft;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " [HP: " + health + ", STR: " + strength + ", CRAFT: " + craft + "]";
    }
}

