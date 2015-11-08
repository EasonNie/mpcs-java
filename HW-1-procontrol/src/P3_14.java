import java.io.PrintStream;
import java.util.Scanner;

public class P3_14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the card notation:");
        String input = s.next();
        System.out.print(parse(input));    //Bring in the input.
    }

    public static String parse(String input) {
        StringBuilder result = new StringBuilder();    //Create a StringBuilder to build the result.

        char[] inputArr = input.toCharArray();
        int len = inputArr.length;

        switch (inputArr[0]) {        //Check the first character.
            case 'J':
                result.append("Jack");
                break;
            case 'Q':
                result.append("Queen");
                break;
            case 'K':
                result.append("King");
                break;
            default:
                result.append(inputArr, 0, len - 1);    //If the first one or two character is numbers.
        }

        result.append(" of ");

        switch (inputArr[(len - 1)]) {        //Check the last character.
            case 'D':
                result.append("Diamonds");
                break;
            case 'H':
                result.append("Hearts");
                break;
            case 'S':
                result.append("Spades");
                break;
            case 'C':
                result.append("Clubs");
                break;
            default:
                result.append("Unknown Type");
        }

        return result.toString();
    }
}