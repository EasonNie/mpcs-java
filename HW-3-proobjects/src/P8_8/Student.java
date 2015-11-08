package P8_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Eason on 10/12/15.
 */
public class Student {
    private String name;
    private ArrayList<Grade> grades;
    private double totalPoint;
    private double GPA;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
        GPA = 0;
        totalPoint = 0;
    }

    public String getName() {
        return name;
    }

    public void addGrade(Grade newGrade) {
        grades.add(newGrade);
        totalPoint += newGrade.getPointGrade();
        this.GPA = this.totalPoint / grades.size();
    }

    public void addGrade(Grade[] newGrades) {
        for (Grade newGrade : newGrades) {
            this.addGrade(newGrade);
        }
    }

    public void addGrade(Collection<Grade> newGrades) {
        for (Grade newGrade : newGrades) {
            this.addGrade(newGrade);
        }
    }

    public double currentGPA() {
        return this.GPA;
    }

    public void getInfo() {
        System.out.printf("Grades for %s are " + grades.toString() + ". Total GPA: %.2f\n", this.name, this.currentGPA());
    }
}
