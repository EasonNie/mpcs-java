package P8_9;

/**
 * Created by Eason on 10/15/15.
 */
public class Test {
    public static void main(String[] args) {
        ComboLock lock1 = new ComboLock(30, 5, 20);
        lock1.turnRight(10);
        lock1.turnLeft(15);
        lock1.turnRight(25);
        //lock1.turnLeft(1);
        System.out.println(lock1.open());
    }
}
