package P8_8;

/**
 * Created by Eason on 10/12/15.
 */
public class Grade {

    private static final String[] GRADES = new String[]{"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
    private static final double[] POINTS = new double[]{4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0};

    private String stringGrade;
    private double pointGrade;

    public Grade(String stringGrade) {
        this.stringGrade = stringGrade;
        for (int i = 0; i < GRADES.length; i++) {
            if (stringGrade.equals(GRADES[i])) {
                pointGrade = POINTS[i];
                break;
            }
        }
    }

    public static String[] getGRADES() {
        return GRADES;
    }

    public double getPointGrade() {
        return pointGrade;
    }

    @Override
    public String toString() {
        return stringGrade;
    }

    public static void getGradeSys() {
        for (int i = 0; i < GRADES.length; i++) {
            System.out.printf("%-2s:%2.1f\n", GRADES[i], POINTS[i]);
        }
    }
}
