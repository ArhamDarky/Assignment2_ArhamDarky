//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Connects two chambers and may be guarded by a monster.
 */
public class Door {
    private final Chamber chamber1;
    private final Chamber chamber2;
    private final Monster monster;

    public Door(Chamber c1, Chamber c2, Monster monster) {
        this.chamber1 = c1;
        this.chamber2 = c2;
        this.monster = monster;
        c1.addDoor(this);
        c2.addDoor(this);
    }

    public Door(Chamber c1, Chamber c2) {
        this(c1, c2, null);
    }

    public Monster getMonster() {
        return monster;
    }

    public Chamber getOtherChamber(Chamber current) {
        return (current == chamber1) ? chamber2 : chamber1;
    }

    public static void connect(Chamber c1, Chamber c2) {
        new Door(c1, c2);
    }

    public static void connect(Chamber c1, Chamber c2, Monster m) {
        new Door(c1, c2, m);
    }
}

