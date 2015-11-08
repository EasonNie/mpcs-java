package P9_8;

/**
 * Created by Eason on 15/10/23.
 */
public class Instructor extends Person {
    private int salary;

    public Instructor(String name, int yearOfBirth, int salary) {
        super(name, yearOfBirth);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " I'm an instructor. My salary is " + salary + ".";
    }
}
