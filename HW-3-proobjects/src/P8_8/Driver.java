package P8_8;

/**
 * Created by Eason on 10/15/15.
 */
public class Driver {
    public static void main(String[] args) {
        //Grade.getGradeSys();
        Student tom = new Student("Tom");
        Student susie = new Student("Susie");
        tom.addGrade(new Grade("A"));
        tom.addGrade(new Grade("B"));
        tom.addGrade(new Grade("F"));
        tom.addGrade(new Grade("B+"));

        Grade[] susieGrade = new Grade[]{new Grade("A"), new Grade("A-"),
                new Grade("B+"), new Grade("A-"), new Grade("C"),
                new Grade("A"), new Grade("B")};
        susie.addGrade(susieGrade);

        susie.getInfo();
        tom.getInfo();

        //System.out.printf("Tom's GPA: %-3.2f\n", tom.currentGPA());
        //System.out.printf("Susie's GPA %-3.2f\n", susie.currentGPA());
    }
}
