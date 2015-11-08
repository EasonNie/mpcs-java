package P8_4;

/**
 * Created by Eason on 10/12/15.
 */
public class Address {
    private int houseNumber;
    private String street;
    private int apartmentNumber;
    private String city;
    private String state;
    private int postalCode;

    public Address(int houseNumber, String street, String city, String state, int postalCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public Address(int houseNumber, String street, int apartmentNumber, String city, String state, int postalCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public void print() {
        System.out.println(this.houseNumber + " " + this.street);
        System.out.print(this.city + ", " + this.state + ", " + postalCode);
        if (apartmentNumber != 0) {     //If the apartmentNumber is initialized, then print it.
            System.out.print(", APT# " + apartmentNumber);
        }
        System.out.println();
    }

    public int getPostalCode() {
        return postalCode;
    }

    public boolean comesBefore(Address other) {
        boolean isBefore = false;
        if (this.postalCode < other.getPostalCode()) {
            isBefore = true;
        }
        return isBefore;
    }
}
