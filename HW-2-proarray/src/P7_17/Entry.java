package P7_17;

import java.io.PrintWriter;
import java.util.NoSuchElementException;

/**
 * Created by Eason on 10/9/15.
 */

//This is a Entry class for the input entry.
public class Entry {


    private String clientName;
    private String serviceCategory;
    private int amount;
    private String date;

    public Entry(String clientName, String serviceCategory, int amount, String date) {
        this.clientName = new String(clientName);
        this.serviceCategory = new String(serviceCategory);
        this.amount = amount;
        this.date = new String(date);
    }

    public static Entry parseToEntry(String[] input) throws NoSuchElementException {
        if (input.length != 4) {
            throw new NoSuchElementException("Incorrect input format.");
        }
        return new Entry(input[0], input[1], Integer.parseInt(input[2]), input[3]);
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    @Override
    public String toString() {      //Override the toString method such that it will produce the correct format.
        return clientName + ';' + serviceCategory + ';' + amount + ';' + date;
    }

    public void writeToFile(PrintWriter out) {
        out.write(this.toString());
    }

}
