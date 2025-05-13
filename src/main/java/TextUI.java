//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Handles the game loop and user input/output.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextUI {
    public void play(Dungeon d) {
        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute(d);
        }
    }

    private void print(Dungeon d) {
        Chamber c = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();
        s.append("You are in a chamber with " + c.getDoors().size() + " doors\n");
        s.append("There are " + c.getItems().size() + " items in the chamber\n");

        int doorNum = 0;
        for (Door door : c.getDoors()) {
            Monster m = door.getMonster();
            if (m != null && m.isAlive()) {
                s.append("Door " + doorNum + " is guarded by " + m.getName() +
                        " [HP: " + m.getHealth() +
                        ", STR: " + m.getStrength() +
                        ", CRAFT: " + m.getCraft() + "]\n");
            }
            doorNum++;
        }

        System.out.println(s.toString());
    }

    private Action ask(Dungeon d) {
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        List<Action> actions = getActions(d);
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.get(i);
            s.append(i + ": " + a.toString() + "\n");
        }
        System.out.println(s.toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            return actions.get(command);
        } catch (IOException | NumberFormatException | IndexOutOfBoundsException e) {
            return new PrintError();
        }
    }

    public List<Action> getActions(Dungeon d) {
        List<Action> actions = new ArrayList<>();
        Chamber c = d.getCurrentChamber();

        for (Item i : c.getItems()) {
            actions.add(new Pick(i));
        }

        for (Door door : c.getDoors()) {
            Monster m = door.getMonster();
            if (m != null && m.isAlive()) {
                actions.add(new Fight(door));
            } else {
                actions.add(new Move(door.getOtherChamber(c), door));
            }
        }

        return actions;
    }
}

