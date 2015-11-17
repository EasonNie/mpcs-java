package yoda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Eason on 11/12/15.
 */
public class YodaSpeak {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your sentence:");
        String[] input = s.nextLine().trim().split(" ");
        reverse(input);
        System.out.println("Reverse output: " + show(input));
    }

    public static String show(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : input) {
            stringBuilder.append(s + " ");
        }
        return stringBuilder.toString().trim();
    }

    public static void reverse(String[] input) {
        int n = input.length;
        if (n == 0) {
            return;
        }
        int i = 0;
        int j = n - 1;
        while (i < j) {
            String tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
            j--;
        }
    }
}
