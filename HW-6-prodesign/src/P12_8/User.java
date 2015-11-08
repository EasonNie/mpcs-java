package P12_8;

import java.util.Scanner;

/**
 * Created by Eason on 11/7/15.
 */
public class User {
    private boolean isThere;

    public User() {
        isThere = true;
    }

    public void addCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.insertCoin(coin);
    }

    public void selectIterm(VendingMachine vendingMachine, String name) {
        vendingMachine.selectProduct(name);
    }

    public void buy(VendingMachine vendingMachine) {
        vendingMachine.purchase();
    }

    public void start(VendingMachine vendingMachine) {
        Scanner s = new Scanner(System.in);
        while(isThere) {
            vendingMachine.display();
            System.out.println("You are an user, what do you want to do:");
            System.out.println("1.Select Product");
            System.out.println("2.Insert Coin");
            System.out.println("3.Purchase");
            System.out.println("4.Leave");
            int i = Integer.parseInt(s.nextLine().trim());
            if (i == 1) {
                System.out.println("Enter product name:");
                String name = s.nextLine();
                selectIterm(vendingMachine, name);
            } else if (i == 2) {
                System.out.println("Enter coin type:(Dollar, Quarter, Dime, Nickel, Pennie)");
                String type = s.nextLine();
                if (type.equalsIgnoreCase("Dollar")) {
                    addCoin(vendingMachine, new Coin(CoinType.Dollar));
                } else if (type.equalsIgnoreCase("Quarter")) {
                    addCoin(vendingMachine, new Coin(CoinType.Quarter));
                } else if (type.equalsIgnoreCase("Dime")) {
                    addCoin(vendingMachine, new Coin(CoinType.Dime));
                } else if (type.equalsIgnoreCase("Nickel")) {
                    addCoin(vendingMachine, new Coin(CoinType.Nickel));
                } else if (type.equalsIgnoreCase("Pennie")) {
                    addCoin(vendingMachine, new Coin(CoinType.Pennie));
                } else {
                    System.out.println("Illegal coin type.");
                }
            } else if (i == 3) {
                this.buy(vendingMachine);
            } else if (i == 4) {
                isThere = false;
                System.out.println("Leaving");
            }
        }
    }
}
