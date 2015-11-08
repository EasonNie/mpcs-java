package P9_8;

/**
 * Created by Eason on 15/10/23.
 */
public class Person {

    private String name;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "My name is " + name + ". I born in " + yearOfBirth + ".";
    }
}
