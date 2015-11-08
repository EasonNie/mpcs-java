package P12_8;

import java.util.Scanner;

/**
 * Created by Eason on 11/7/15.
 */
public class Operator {
    private boolean isThere;

    public Operator() {
        this.isThere = true;
    }

    public void addProduct(VendingMachine vendingMachine, Product product) {
        vendingMachine.restock(product);
    }

    public void remove(VendingMachine vendingMachine, String name) {
        vendingMachine.remove(name);
    }

    public void start(VendingMachine vendingMachine) {
        Scanner s = new Scanner(System.in);
        while(isThere) {
            vendingMachine.display();
            System.out.println("You are an operator, what do you want to do:");
            System.out.println("1.Restock.");
            System.out.println("2.Remove item");
            System.out.println("3.Leave");
            int i = Integer.parseInt(s.nextLine().trim());
            if (i == 1) {
                System.out.println("Enter product name:");
                String name = s.nextLine().trim();
                System.out.println("Enter product price");
                double price = Double.parseDouble(s.nextLine().trim());
                vendingMachine.restock(new Product(name, price));
            } else if (i == 2) {
                System.out.println("Enter product name:");
                String name = s.nextLine().trim();
                vendingMachine.remove(name);
            } else if (i == 3) {
                isThere = false;
                System.out.println("Leaving");
            }
        }
    }
}
