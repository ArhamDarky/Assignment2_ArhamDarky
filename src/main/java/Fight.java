//------------------------------------
// Assignment 2
// Written By: Arham Darky 2186561
// For SE350 Section 602 - Spring 2025
//------------------------------------

/**
 * Fight action — engages monster guarding a door.
 */
import java.util.Random;

public class Fight extends Action {
    private final Door door;
    private final Random random = new Random();

    public Fight(Door door) {
        this.door = door;
    }

    @Override
    public void execute(Dungeon dungeon) {
        Monster monster = door.getMonster();
        Character player = dungeon.getPlayer();

        int playerStat = (monster.getStrength() == 0) ? player.getTotalCraft() : player.getTotalStrength();
        int monsterStat = (monster.getStrength() == 0) ? monster.getCraft() : monster.getStrength();

        int playerRoll = random.nextInt(6) + 1 + playerStat;
        int monsterRoll = random.nextInt(6) + 1 + monsterStat;

        int damage = Math.abs(playerRoll - monsterRoll);
        if (playerRoll > monsterRoll) {
            monster.takeDamage(damage);
        } else {
            player.takeDamage(damage);
        }
    }

    @Override
    public String toString() {
        return "Fight monster guarding door";
    }
}
