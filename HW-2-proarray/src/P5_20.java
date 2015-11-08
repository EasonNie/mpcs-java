/**
 * Created by Eason on 10/5/15.
 */
import java.util.Scanner;

public class P5_20 {

    public static void main(String[] args) {
        System.out.print("Enter the year:");
        Scanner s = new Scanner(System.in);
        int year = s.nextInt();
        if (isLeapYear(year)) {
            System.out.println("It is a leap year");
        } else {
            System.out.println("It is not a leap year.");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
