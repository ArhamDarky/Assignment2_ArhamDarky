//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Move action — lets the player move to another chamber if monster is dead or absent.
 */
public class Move extends Action {
    private final Chamber next;
    private final Door door;

    public Move(Chamber next, Door door) {
        this.next = next;
        this.door = door;
    }

    @Override
    public void execute(Dungeon dungeon) {
        Monster monster = door.getMonster();
        if (monster == null || !monster.isAlive()) {
            dungeon.moveTo(next);
        }
    }

    @Override
    public String toString() {
        return "Move to another chamber";
    }
}

