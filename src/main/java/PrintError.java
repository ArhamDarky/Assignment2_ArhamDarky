//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Error action — triggered when user input is invalid.
 */
public class PrintError extends Action {
    @Override
    public void execute(Dungeon dungeon) {
        System.out.println("Invalid input. Try again.");
    }

    @Override
    public String toString() {
        return "Invalid";
    }
}

