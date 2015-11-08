package P12_8;

/**
 * Created by Eason on 11/7/15.
 */
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        if (p.getName().equals(this.name)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        char[] arr = name.toCharArray();
        int checksum = 0;
        for (char c : arr) {
            checksum = checksum + c;
        }
        return checksum;
    }
}
