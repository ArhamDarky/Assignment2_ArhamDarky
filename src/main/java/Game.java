//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Entry point of the Dungeon RPG game.
 */
public class Game {
    public static void main(String[] args) {
        // Create character
        Character player = new Warrior("Arham");

        // Create items
        Item axe = new Axe();
        Item shield = new Shield();

        // Create chambers
        Chamber start = new Chamber(axe);
        Chamber middle = new Chamber(shield);
        Chamber end = new Chamber();

        // Create monster
        Monster troll = new Monster("Troll", 3, 0, 8);

        // Connect chambers
        Door.connect(start, middle, troll); // guarded
        Door.connect(middle, end);          // unguarded

        // Create dungeon
        Dungeon dungeon = new Dungeon(player, start, end);

        // Start game
        TextUI ui = new TextUI();
        ui.play(dungeon);

        // End result
        if (!player.isAlive()) {
            System.out.println("You died. Game over.");
        } else {
            System.out.println("You reached the goal chamber! You win!");
        }
    }
}
