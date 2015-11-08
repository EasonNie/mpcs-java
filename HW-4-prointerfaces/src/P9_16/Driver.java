package P9_16;

/**
 * Created by Eason on 15/10/23.
 */
public class Driver {
    public static void main(String[] args) {
        Measurable[] countries = new Measurable[3];
        countries[0] = new Country("Uruguay", 176220);
        countries[1] = new Country("Thailand", 514000);
        countries[2] = new Country("Belgium", 30510);
        System.out.println("The country with maximum area in the array is : " + maximum(countries));
    }

    public static Measurable maximum(Measurable[] objects) {
        double max = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].getMeasure() > max) {
                k = i;
                max = objects[i].getMeasure();
            }
        }

        return objects[k];
    }
}
