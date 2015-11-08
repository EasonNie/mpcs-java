import java.io.PrintStream;
import java.util.Scanner;


public class P3_18 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter three strings:");
        String s1 = s.next();
        String s2 = s.next();
        String s3 = s.next();

        int s1_s2 = s2.compareTo(s1);
        int s1_s3 = s3.compareTo(s1);
        int s2_s3 = s3.compareTo(s2);    //Compare each pair of the input letters.

        if ((s1_s2 > 0) && (s1_s3 > 0) && (s2_s3 > 0)) {
            printByorder(s1, s2, s3);
        } else if ((s1_s2 > 0) && (s1_s3 > 0) && (s2_s3 < 0)) {
            printByorder(s1, s3, s2);
        } else if ((s1_s2 > 0) && (s1_s3 < 0)) {
            printByorder(s3, s1, s2);
        } else if ((s1_s2 < 0) && (s2_s3 < 0)) {
            printByorder(s3, s2, s1);
        } else if ((s1_s2 < 0) && (s1_s3 < 0) && (s2_s3 > 0)) {
            printByorder(s2, s3, s1);
        } else if ((s1_s2 < 0) && (s1_s3 > 0)) {
            printByorder(s2, s1, s3);
        }
    }

    public static void printByorder(String s1, String s2, String s3) {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}