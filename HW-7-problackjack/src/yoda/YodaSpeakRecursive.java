package yoda;

import java.util.Scanner;

/**
 * Created by Eason on 11/12/15.
 */
public class YodaSpeakRecursive {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your sentence:");
        String[] input = s.nextLine().trim().split(" ");
        reverse(input, 0, input.length - 1);
        System.out.println("Reverse output: " + show(input));
    }

    public static String show(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : input) {
            stringBuilder.append(s + " ");
        }
        return stringBuilder.toString().trim();
    }

    public static void reverse(String[] input, int start, int end) {
        if (start >= end) {
            return;
        } else {
            String tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
            reverse(input, start + 1, end - 1);
        }
    }

}
