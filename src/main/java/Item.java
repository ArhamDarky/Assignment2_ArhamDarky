//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Abstract class representing an item that boosts strength or craft.
 */
public abstract class Item {
    private final String name;
    private final int strengthBoost;
    private final int craftBoost;

    public Item(String name, int strengthBoost, int craftBoost) {
        this.name = name;
        this.strengthBoost = strengthBoost;
        this.craftBoost = craftBoost;
    }

    public String getName() {
        return name;
    }

    public int getStrengthBoost() {
        return strengthBoost;
    }

    public int getCraftBoost() {
        return craftBoost;
    }

    @Override
    public String toString() {
        return name + " (+" + strengthBoost + " STR, +" + craftBoost + " CRAFT)";
    }
}


