import java.io.PrintStream;
import java.util.Scanner;


public class P3_26 {
    static final char[] digit1 = {'I', 'V', 'X'};        //digits for the 10e0
    static final char[] digit10 = {'X', 'L', 'C'};        //digits for the 10e1
    static final char[] digit100 = {'C', 'D', 'M'};    //digits for the 10e2
    static final char[] digit1000 = {'M'};                //digits for the 10e3
    static final char[][] digits = {digit1, digit10, digit100, digit1000};

    //digits[I] is digis for 10eI
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number:");

        int n = s.nextInt();
        int len = (int) Math.log10(n) + 1;
        String[] digitsArr = new String[len];

        for (int i = 0; i < len; i++) {    //For each digit calculate the roman String.
            int curDigit = n % 10;
            digitsArr[i] = digitGenerator(i, curDigit);
            n /= 10;
        }

        StringBuilder result = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            result.append(digitsArr[i]);        //Append each String for digits from len-1 to 0
        }

        System.out.println(result.toString());
    }

    public static String digitGenerator(int i, int n) {    //Build Roman String of a given digits.
        char[] d = digits[i];
        StringBuilder result = new StringBuilder();
        if (n <= 3) {
            while (n > 0) {
                result.append(d[0]);    //If n<=3, string: n*I
                n--;
            }
        } else if (n == 4) {
            result.append(d[0]).append(d[1]);    //If n=4, string: IV
        } else if ((n >= 5) && (n <= 8)) {
            result.append(d[1]);
            while (n > 5) {                        //If 5<=n<=8, string V+(n-5)*I
                result.append(d[0]);
                n--;
            }
        } else {
            result.append(d[0]).append(d[2]);    //If n=9, string is IX
        }
        return result.toString();
    }
}


/* Location:              /Users/Eason/Documents/mpcs/procontrolClass/!/P3_26.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */