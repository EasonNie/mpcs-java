import java.io.PrintStream;
import java.util.Scanner;


public class P4_18 {
    public static void main(String[] args) {
        System.out.print("Please enter an integer:");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 2; i <= n; i++) {        //For i from 2 to n, check if i is a prime.
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {        //For i from 2 to sqrt(n), check if n can be divided by i.
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//Edited by Yixin(Eason) Nie
//Test for update.2:58
