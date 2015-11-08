package P8_4;

/**
 * Created by Eason on 10/12/15.
 */
public class Driver {
    public static void main(String[] args) {
        Address address1 = new Address(5020, "South Lake Shore Dr.", "Chicago", "IL", 60615);
        address1.print();
        Address address2 = new Address(5020, "South Lake Shore Dr.", 2011, "Chicago", "IL", 60610);
        address2.print();
        System.out.println("Whether address2 comes before address1: " + address2.comesBefore(address1));
    }

}
