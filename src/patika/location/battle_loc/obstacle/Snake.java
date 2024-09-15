package patika.location.battle_loc.obstacle;

import patika.location.battle_loc.Obstacle;

import java.util.Random;

public class Snake extends Obstacle {
    private static final int MIN_DAMAGE = 3;
    private static final int MAX_DAMAGE = 6;

    public Snake() {
        super(4, snakeDamage(), 12, "Yılan", 1);
    }

    public static int snakeDamage() {
        Random random = new Random();
        return random.nextInt((MAX_DAMAGE - MIN_DAMAGE) + 1) + MIN_DAMAGE;
    }
}
