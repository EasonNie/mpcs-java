package P9_8;

/**
 * Created by Eason on 15/10/23.
 */
public class Student extends Person {
    private String major;

    public Student(String name, int yearOfBirth, String major) {
        super(name, yearOfBirth);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return super.toString() + " I'm a Student majoring in " + major + ".";
    }
}
