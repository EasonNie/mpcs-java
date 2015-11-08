package P7_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Eason on 10/9/15.
 */

//This is a class for generating test cases for the P7_17. Running this class will create a file called "TestCase.txt" in the current path.

public class P7_17_TestCaseGenerator {
    final static String[] Names = {
            "Angelo Bailey",
            "Charlotte Bowen",
            "Hilda Bennett",
            "Ira Price",
            "Marcos Rose",
            "Estelle Greer",
            "Gina Montgomery",
            "Ervin Sanders",
            "Barry Jordan",
            "Natasha Hoffman",
            "Wanda Fox",
            "Horace Wood",
            "Ruth Kelly",
            "Pedro Griffin",
            "Gwen Howell",
            "Rudolph Soto",
            "Clifford Moran",
            "Samuel	Lamb",
            "Alicia	Conner",
            "Rickey	Lyons",
            "Adam Carlson",
            "Christopher Ray",
            "Roosevelt Duncan",
            "Darrell Burns",
            "Harriet Barnes",
            "Sam Thomas",
            "Jimmie	Mack",
            "Francisco Ortega",
            "Jeannette Byrd",
            "Verna Pierce",
            "Norman Gomez",
            "Steven Palmer",
            "Muriel Riley",
            "Caroline Pittman",
            "Antoinette	Meyer",
            "Randolph Robertson",
            "Cornelius Adams",
            "Jean Cohen",
            "Brett Sherman",
            "Delbert Flowers",
            "Pete Myers",
            "Christian Morris",
            "Lyle Cross",
            "Marie Mckenzie",
            "Katrina Dean",
            "Tara Lewis",
            "Mario Drake",
            "Frank Simpson",
            "Jeffrey Holloway",
            "Alberto Crawford"};
    final static String[] Categories = {
            "Conference_A",
            "Conference_B",
            "Conference_C",
            "Conference_D",
            "Dinner_A",
            "Dinner_B",
            "Dinner_C",
            "Lodging_A",
            "Lodging_B",
            "Lodging_C",
            "Lodging_D"};//These are the test category for the test case.

    public static int randomGenerator(int max) {
        return ((int) (Math.random() * 100)) % max;
    }

    public static Entry getRandomEntry() {  //Generate an entry randomly.
        String clientName = Names[randomGenerator(Names.length)];
        String category = Categories[randomGenerator(Categories.length)];
        int amount = randomGenerator(11);
        Date curDate = new Date(System.currentTimeMillis() - (long) randomGenerator(1000) * 1000000000);    //Choose the time randomly.
        return new Entry(clientName, category, amount, curDate.toString());
    }

    public static void main(String[] args) {
        File testCase = new File("src/P7_17/TestCase.txt");
        try (PrintWriter out = new PrintWriter(testCase)) {
            int n = 100;
            while (n > 0) {             //Write 100 test case to the file.
                getRandomEntry().writeToFile(out);
                out.println();
                n--;
            }
            out.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Output File not Found.");
        }
    }
}
