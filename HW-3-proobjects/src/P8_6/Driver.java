package P8_6;

/**
 * Created by Eason on 10/15/15.
 */
public class Driver {
    public static void main(String[] args) {
        Car ford = new Car(50);
        ford.addGas(20);
        ford.drive(100);
        System.out.printf("%.2f\n", ford.getFuelLevel());
    }
}
