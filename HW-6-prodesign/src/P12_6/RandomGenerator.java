package P12_6;

import java.util.Random;

/**
 * Created by Eason on 11/7/15.
 */
public class RandomGenerator {  //Singleton
    private static Random random;

    private RandomGenerator() {

    }

    public static int getRandomInt(int from, int to) {
        if (random == null) {
            random = new Random(System.currentTimeMillis());
        }
        return from + random.nextInt(to - from);
    }
}
