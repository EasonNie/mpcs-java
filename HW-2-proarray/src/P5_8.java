/**
 * Created by Eason on 10/5/15.
 */

import java.util.Scanner;

public class P5_8 {

    public static void main(String[] args) {
        System.out.println("Enter words:");
        //January February March April May June July August September October November December
        //Monday Tuesday Wednesday Thursday Friday Saturday Sunday

        Scanner s = new Scanner(System.in);
        String line = null;
        String[] words = {""};

        line = s.nextLine();

        if (line != null) {
            words = line.split(" ");
        }
        int n = 5;
        while(n >= 0) {
            for (String word : words) {
                System.out.print(scramble(word));
                System.out.print(" ");
            }
            n--;
            System.out.println();
        }

    }

    public static String scramble(String word) {
        if (word.length() == 0 || word.length() == 1 || word.length() == 2 || word.length() == 3) {
            return word;
        }   //Boundary checking
        char[] wordArr = word.toCharArray();
        int index1 = (int) (Math.random() * 10) % (word.length() - 2) + 1;
        int index2 = index1;
        
        //Randomly choosing index1 and index2
        while (index2 == index1) {
            index2 = index1 + (int) (Math.random() * 10);
            index2 = index2 % (word.length() - 2) + 1;
        }

        char tmp = wordArr[index1];
        wordArr[index1] = wordArr[index2];
        wordArr[index2] = tmp;

        //System.out.print("(" + index1 + ":" + index2 + ")");

        return new String(wordArr);
    }


}
