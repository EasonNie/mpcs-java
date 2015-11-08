package P10_35;

/**
 * Created by Eason on 10/31/15.
 */
public class Test {
    public static void main(String[] args) {
        Item i = new Item("A", 100);
        Bill b = new Bill(1);
        b.billed();
        b.addItem(i);
        System.out.println(b);
    }
}
