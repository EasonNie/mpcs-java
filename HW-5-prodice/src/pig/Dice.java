package pig;

import java.util.Random;

/**
 * Created by Eason on 10/31/15.
 */
public class Dice {
    Random random;
    private int number;

    public Dice() {
        random = new Random(System.currentTimeMillis());
    }

    public int roll() {
        number = 1 + random.nextInt(6);
        return number;
    }
}
