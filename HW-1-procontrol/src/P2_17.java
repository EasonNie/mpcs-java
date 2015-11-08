import java.io.PrintStream;
import java.util.Scanner;


public class P2_17 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Please enter the first time:");    //Receive the first time.
        String fst_time = s.next();
        int fst_h = Integer.parseInt(fst_time.substring(0, 2));
        int fst_m = Integer.parseInt(fst_time.substring(2, 4));

        System.out.print("Please enter the second time:");    //Receivee the second time.
        String sec_time = s.next();
        int sec_h = Integer.parseInt(sec_time.substring(0, 2));
        int sec_m = Integer.parseInt(sec_time.substring(2, 4));

        int m = sec_m - fst_m;    //Calculate the gap between two time.
        int h = sec_h - fst_h;

        if (m < 0) {    //If mins is less than 0 then hours-1 and mins+60
            h -= 1;
            m += 60;
        }

        if (h < 0) {    //If hours is less than 0 then hours+24
            h += 24;
        }

        System.out.println(h + " hours " + m + " minutes");
    }
}