package P10_35;

/**
 * Created by Eason on 10/31/15.
 */
public class Item {
    private String itemName;
    private double price;

    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String str = String.format("%-20s    %6.2f", itemName, price);
        return str;
    }
}
