//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Abstract base class representing a character with strength, craft, and health.
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final String name;
    protected int strength;
    protected int craft;
    private int health;
    private final List<Item> inventory;

    public Character(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
        this.inventory = new ArrayList<>();
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        if (inventory.size() < 2) {
            inventory.add(item);
        }
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getTotalStrength() {
        int boost = inventory.stream().mapToInt(Item::getStrengthBoost).sum();
        return strength + boost;
    }

    public int getTotalCraft() {
        int boost = inventory.stream().mapToInt(Item::getCraftBoost).sum();
        return craft + boost;
    }

    @Override
    public String toString() {
        return name + " [HP: " + health + ", STR: " + strength + ", CRAFT: " + craft + "]";
    }
}

