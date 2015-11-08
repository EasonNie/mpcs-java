package P7_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Eason on 10/9/15.
 */
public class P7_17 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //System.out.print("Input file: ");
        String inputFileName;
        inputFileName = "src/P7_17/TestCase.txt";
        //This program use the path "src/P7_17/TestCase.txt" as input file.
        //The root of this file the root of this project.

        String outputDirName = "src/P7_17/output_for_P7_17";
        //All the output file will be in the output_for_P7_17 directory.

        File outputDir = new File(outputDirName);
        outputDir.mkdirs();         //Make the output directiory.
        File inputFile = new File(inputFileName);

        Map<String, PrintWriter> categoryMap = new HashMap<>();     //Build a hashMap to maintain print_writers for each category.

        try (Scanner scanner = new Scanner(inputFile)) {

            while (scanner.hasNextLine()) {
                Entry curEntry = Entry.parseToEntry(scanner.nextLine().trim().split(";"));  //Parse the input to an entry instance.
                String category = curEntry.getServiceCategory();                            //Check the category of the entry.
                if (categoryMap.containsKey(category)) {
                    //If this category can be found in the HashMap
                        //Write the entry to the certain printWriter

                    PrintWriter out = categoryMap.get(category);
                    curEntry.writeToFile(out);
                    out.println();
                } else {
                    //If this category can not be found in the HashMap
                        //construct a new PrintWriter pointing at a new file with the name of the category.
                        //put this PrintWriter to the HashMap

                    File outputFile = new File (outputDirName + "/" + category + ".txt");
                    PrintWriter out = new PrintWriter(outputFile);
                    categoryMap.put(category, out);
                    curEntry.writeToFile(out);
                    out.println();
                }
            }
            for (PrintWriter pw : categoryMap.values()) {
                pw.flush();     //For each PrintWriter in the HaspMap call the method flush().
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input File Not Found.");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            //This exception will be thrown by the Entry.parseToEntry() method when the format is incorrect.
            //You can see the details about this in the declaration of Entry.parseToEntry() method.
        }

    }
}