package P8_15;

import java.util.Scanner;

/**
 * Created by Eason on 10/15/15.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the type (Cone, Sphere or Cylinder):");
        String type = s.nextLine().trim();

        double r;
        double h;
        Shape inputShape;

        if (type.equalsIgnoreCase("cone")) {
            r = getR(s);
            h = getH(s);
            inputShape = new Cone(r, h);

        } else if (type.equalsIgnoreCase("sphere")) {
            r = getR(s);
            inputShape = new Sphere(r);

        } else if (type.equalsIgnoreCase("cylinder")) {
            r = getR(s);
            h = getH(s);
            inputShape = new Cylinder(r, h);

        } else {
            System.out.println("Illegal Type.");
            return;
        }

        inputShape.print();
    }

    public static double getR(Scanner s) {
        System.out.print("Enter the radius:");
        return Double.parseDouble(s.nextLine().trim());
    }

    public static double getH(Scanner s) {
        System.out.print("Enter the height:");
        return Double.parseDouble(s.nextLine().trim());
    }
}
