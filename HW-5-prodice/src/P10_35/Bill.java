package P10_35;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Eason on 10/31/15.
 */
public class Bill {
    ArrayList<Item> items;
    private double price;
    private double tip;
    private int Id;
    private boolean billed = false;

    public boolean addItem(Item item) {
        if (!billed) {
            items.add(item);
            price = price + item.getPrice();
            tip = price * 0.15;
            return true;
        } else {
            return false;
        }
    }

    public Bill(int id) {
        this.Id = id;
        items = new ArrayList<>();
        price = 0;
        tip = 0;
    }

    public void removeLast() {
        if (!billed) {
            if (items.size() == 0) {
                return;
            } else {
                this.price = price - items.get(items.size() - 1).getPrice();
                this.tip = price * 0.15;
                items.remove(items.size() - 1);
            }
        }
    }

    public void billed() {
        this.billed = true;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Order # " + Id + "\n");
        str.append("Date: " + Calendar.getInstance().getTime() + "\n");
        str.append("\n");
        str.append("------------Bill Info------------\n");
        for (Item item : items) {
            str.append(item.toString() + "\n");
        }
        str.append("\n------------------------------\n");
        if (billed) {
            str.append(String.format("%-20s    %6.2f\n", "Price:", price));
            str.append(String.format("%-20s    %6.2f\n", "Tip:", tip));
            str.append("------------------------------\n");
            str.append(String.format("%-20s    %6.2f\n", "Total:", price + tip));
        }
        return str.toString();
    }
}
