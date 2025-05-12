//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Represents a room in the dungeon. Can contain items and doors to other chambers.
 */
import java.util.ArrayList;
import java.util.List;

public class Chamber {
    private final List<Item> items = new ArrayList<>();
    private final List<Door> doors = new ArrayList<>();

    public Chamber() {}

    public Chamber(Item item) {
        items.add(item);
    }

    public void addItem(Item item) {
        if (items.size() < 2) {
            items.add(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    public List<Door> getDoors() {
        return doors;
    }
}

