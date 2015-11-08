package P9_14;

/**
 * Created by Eason on 10/23/15. Reserved.
 */
public class Driver {
    public static void main(String[] args) {
        Measurable[] sodacans = new SodaCan[3];
        sodacans[0] = new SodaCan(1,2);
        sodacans[1] = new SodaCan(2,3);
        sodacans[2] = new SodaCan(3,4);
        System.out.printf("Average Surface Area of these Soda Cans is : %.2f\n", averageSurfaceArea(sodacans));
    }

    public static double averageSurfaceArea(Measurable[] objects) {
        double sum = 0;
        int n = objects.length;
        if (objects == null || objects.length == 0) {
            return 0;
        } else {
            for (Measurable obj : objects) {
                sum = sum + obj.getMeasure();
            }
        }
        return sum / n;
    }
}
