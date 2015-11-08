package P8_11;

import java.util.Scanner;

/**
 * Created by Eason on 10/15/15.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter sender's name:");
        String sender = s.nextLine();
        System.out.print("Enter receiver name:");
        String receiver = s.nextLine();
        Letter letter = new Letter(sender, receiver);

        System.out.println("Enter your letter (Stop the input by entering a single line \"end\")");
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.equalsIgnoreCase("end")) {
                break;
            } else {
                letter.addLine(line);
            }
        }

        System.out.println("\n--------------YOUR-LETTER---------------\n");

//        letter = new Letter("Mary", "John");
//        letter.addLine("I am sorry we must part.");
//        letter.addLine("I wish you all the best.");
//        letter.addLine("...Something hidden...");
        System.out.println(letter.getText());
    }
}
