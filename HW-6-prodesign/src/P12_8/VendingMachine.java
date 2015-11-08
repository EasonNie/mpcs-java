package P12_8;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eason on 11/7/15.
 */
public class VendingMachine {
    private Map<Product, Integer> items;
    private double curMoney;
    private Product selectedProduct;

    public VendingMachine() {
        this.items = new HashMap<Product, Integer>();
        this.curMoney = 0;
        this.selectedProduct = null;
    }

    public void display() {
        System.out.println("curMoney: " + curMoney);
        System.out.println("------Product Info------");
        System.out.println("---Name---|--Price--|--Count--");
        for(Product item : items.keySet()) {
            System.out.println(String.format("%10s|%9.2f|%9d", item.getName(), item.getPrice(), items.get(item)));
        }
    }

    public void insertCoin(Coin coin) {
        curMoney += coin.getValue();
        System.out.println("Insert successfully");
    }

    public void selectProduct(String name) {
        for(Product item : items.keySet()) {
            if (item.getName().equals(name)) {
                selectedProduct = item;
                System.out.println("Item selected");
                break;
            }
        }
        if (selectedProduct == null) {
            System.out.println("No item has been found with the name: " + name);
        }
    }

    public void purchase() {
        if (selectedProduct == null) {
            System.out.println("Please select a product");
        } else {
            if (selectedProduct.getPrice() <= curMoney) {
                if (items.get(selectedProduct) > 0) {
                    items.put(selectedProduct, items.get(selectedProduct) - 1);
                    System.out.println("Purchasing finished");
                    curMoney = 0;
                    selectedProduct = null;
                } else {
                    curMoney = 0;
                    System.out.println("No stock. Cash return.");
                }
            } else {
                curMoney = 0;
                System.out.println("Not enough money. Cash return.");
            }
        }
    }

    public void restock(Product product) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + 1);
        } else {
            items.put(product, 1);
        }
    }

    public void remove(String name) {
        Product product = new Product(name, 0);
        if (items.containsKey(product)) {
            int i = items.get(product);
            if (i == 0) {
                System.out.println("No stock");
            } else {
                items.put(product, i - 1);
                System.out.println("Remove successfully.");
            }
        } else {
            System.out.println("No such items");
        }
    }

    public void remove(Product product) {
        if (items.containsKey(product)) {
            int i = items.get(product);
            if (i == 0) {
                System.out.println("No stock");
            } else {
                items.put(product, i - 1);
                System.out.println("Remove successfully.");
            }
        } else {
            System.out.println("No such items");
        }
    }

}
