package P9_8;

/**
 * Created by Eason on 15/10/23.
 */
public class Driver {
    public static void main(String[] args) {
        Person p1 = new Student("Bob", 1990, "Computer Science");
        Person p2 = new Instructor("Sam", 1978, 10000);
        System.out.println(p1);
        System.out.println(p2);
    }
}
