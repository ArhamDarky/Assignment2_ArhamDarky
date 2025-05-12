//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Represents the state of the game. Tracks player and current/goal chambers.
 */
public class Dungeon {
    private final Character player;
    private Chamber currentChamber;
    private final Chamber goalChamber;

    public Dungeon(Character player, Chamber start, Chamber goal) {
        this.player = player;
        this.currentChamber = start;
        this.goalChamber = goal;
    }

    public Character getPlayer() {
        return player;
    }

    public Chamber getCurrentChamber() {
        return currentChamber;
    }

    public void moveTo(Chamber next) {
        this.currentChamber = next;
    }

    public boolean isFinished() {
        return !player.isAlive() || currentChamber == goalChamber;
    }
}

