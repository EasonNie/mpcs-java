import java.io.PrintStream;
import java.util.Scanner;


public class P4_11 {
    static final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

    public static void main(String[] args) {
        System.out.print("Enter a word:");
        Scanner s = new Scanner(System.in);
        char[] charArr = s.next().toCharArray();
        int numOfSyllables = 0;

        boolean flag = true;


        for (int i = 0; i < charArr.length; i++) {
            if ((isVowels(charArr[i])) && (flag)) {
                if ((i != charArr.length - 1) || (charArr[i] != 'e')) {


                    numOfSyllables++;
                    flag = false;
                }

            } else if (!isVowels(charArr[i])) {
                flag = true;
            }
        }

        System.out.println("Numbers of Syllables: " + numOfSyllables);
    }


    public static boolean isVowels(char c) {
        for (char e : vowels) {
            if (c == e) {
                return true;
            }
        }
        return false;
    }
}
