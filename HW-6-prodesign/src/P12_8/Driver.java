package P12_8;

import java.util.Scanner;

/**
 * Created by Eason on 11/7/15.
 */
public class Driver {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Select your role:");
            System.out.println("1.User");
            System.out.println("2.Operator");
            System.out.println("3.Exit");
            int i = Integer.parseInt(s.nextLine().trim());
            if (i == 1) {
                new User().start(vm);
            } else if (i == 2) {
                new Operator().start(vm);
            } else if (i == 3) {
                System.out.println("Exit......");
                break;
            }
        }
    }
}
