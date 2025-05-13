//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Unit tests for the Character class and its subclasses.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testAddItemAndStatBoost() {
        Character wizard = new Wizard("TestWizard");
        wizard.addItem(new Axe());   // +2 STR
        wizard.addItem(new Shield()); // +2 CRAFT

        assertEquals(2, wizard.getTotalStrength());
        assertEquals(5, wizard.getTotalCraft()); // 3 base + 2
    }

    @Test
    public void testTakeDamageReducesHealth() {
        Character warrior = new Warrior("TestWarrior");
        warrior.takeDamage(4);
        assertEquals(6, warrior.getHealth());
    }

    @Test
    public void testHealthDoesNotGoNegative() {
        Character wizard = new Wizard("HPClampTest");
        wizard.takeDamage(20);
        assertEquals(0, wizard.getHealth());
    }

    @Test
    public void testIsAliveReturnsCorrectly() {
        Character warrior = new Warrior("AliveCheck");
        assertTrue(warrior.isAlive());
        warrior.takeDamage(10);
        assertFalse(warrior.isAlive());
    }

    @Test
    public void testInventoryLimitIsTwo() {
        Character wizard = new Wizard("InventoryTest");
        wizard.addItem(new Axe());
        wizard.addItem(new Shield());
        wizard.addItem(new Axe()); // should be ignored

        assertEquals(2, wizard.getInventory().size());
    }

    @Test
    public void testRemoveItemFromInventory() {
        Character wizard = new Wizard("RemoveTest");
        Item axe = new Axe();
        wizard.addItem(axe);
        wizard.removeItem(axe);

        assertEquals(0, wizard.getInventory().size());
    }

    @Test
    public void testToStringFormat() {
        Character warrior = new Warrior("FormatTest");
        String str = warrior.toString();
        assertTrue(str.contains("HP:"));
        assertTrue(str.contains("STR:"));
        assertTrue(str.contains("CRAFT:"));
    }
}


