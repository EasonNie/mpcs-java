import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Eason on 10/8/15.
 */
public class P7_2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = s.next();
        //inputFileName = "input_forP7_2.txt";
        System.out.print("Output file: ");
        String outputFileName = s.next();   //The root path is the root of this project.
        //outputFileName = "out.txt";

        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);


        try (PrintWriter out = new PrintWriter(outputFile);
             Scanner scanner = new Scanner(inputFile)) {

            int lineNum = 1;

            while(scanner.hasNextLine()) {
                out.println("/* " + lineNum + " */ " + s.nextLine());
                lineNum++;
            }

            out.flush();

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Input File Not Found.");
        }
    }

}
