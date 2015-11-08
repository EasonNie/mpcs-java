import java.io.PrintStream;
import java.util.Scanner;

public class P3_21 {
    public static void main(String[] args) {
        System.out.print("Please enter your original income:");
        Scanner s = new Scanner(System.in);
        double rawIncome = Integer.parseInt(s.next());
        double tax = countsTax(rawIncome);
        double afterTax = rawIncome - tax;
        System.out.println("Your income tax is: " + String.format("%.2f", new Object[]{Double.valueOf(tax)}));
        System.out.println("Your income after tax is: " + String.format("%.2f", new Object[]{Double.valueOf(afterTax)}));
    }

    public static double countsTax(double income) {
        double tax = 0.0D;
        if (income <= 50000.0D) {
            tax = income * 0.01D;
        } else if ((income > 50000.0D) && (income <= 75000.0D)) {
            tax = 500.0D + (income - 50000.0D) * 0.02D;
        } else if ((income > 75000.0D) && (income <= 100000.0D)) {
            tax = 1000.0D + (income - 75000.0D) * 0.03D;
        } else if ((income > 100000.0D) && (income <= 250000.0D)) {
            tax = 1750.0D + (income - 100000.0D) * 0.04D;
        } else if ((income > 250000.0D) && (income <= 500000.0D)) {
            tax = 7750.0D + (income - 250000.0D) * 0.05D;
        } else if (income > 500000.0D) {
            tax = 20250.0D + (income - 500000.0D) * 0.06D;
        }
        return tax;
    }
}
