package P8_14;

import java.util.Scanner;

/**
 * Created by Eason on 10/15/15.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the radius:");
        double r = Double.parseDouble(s.nextLine().trim());
        System.out.print("Enter the height:");
        double h = Double.parseDouble(s.nextLine().trim());
//        double r = 4;
//        double h = 5;
        System.out.printf("The Volume of sphere with radius %.2f is %.2f\n", r, Geometry.sphereVolume(r));
        System.out.printf("The Surface of sphere with radius %.2f is %.2f\n", r, Geometry.sphereSurface(r));
        System.out.printf("The Volume of cylinder with radius %.2f and height %.2f is %.2f\n", r, h, Geometry.cylinderVolume(r, h));
        System.out.printf("The Surface of cylinder with radius %.2f and height %.2f is %.2f\n", r, h, Geometry.cylinderSurface(r, h));
    }
}
