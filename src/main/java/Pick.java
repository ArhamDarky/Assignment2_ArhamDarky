//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Pick action — lets the player pick up an item from the current chamber.
 */
public class Pick extends Action {
    private final Item item;

    public Pick(Item item) {
        this.item = item;
    }

    @Override
    public void execute(Dungeon dungeon) {
        dungeon.getPlayer().addItem(item);
        dungeon.getCurrentChamber().removeItem(item);
    }

    @Override
    public String toString() {
        return "Pick up item: " + item.getName();
    }
}

