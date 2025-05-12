//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Abstract class for all player actions (e.g. Fight, Move, Pick).
 */
public abstract class Action {
    public abstract void execute(Dungeon dungeon);
    public abstract String toString();
}

