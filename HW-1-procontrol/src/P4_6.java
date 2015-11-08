import java.io.PrintStream;
import java.util.Scanner;


public class P4_6 {
    public static void main(String[] args) {
        System.out.println("Enter your number array: (You can finish the input by entering any character that is not a number)");
        Scanner s = new Scanner(System.in);
        boolean first = true;
        int minimum = Integer.MAX_VALUE;
        while (s.hasNextInt()) {
            int nextValue = s.nextInt();
            if (first) {
                minimum = nextValue;
                first = false;
            } else if (nextValue < minimum) {
                minimum = nextValue;
            }
        }

        if (first) {
            System.out.println("No number have been entered.");
        } else {
            System.out.println("Minimum is: " + minimum);
        }
    }
}
