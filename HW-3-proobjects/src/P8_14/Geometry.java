package P8_14;

/**
 * Created by Eason on 10/15/15.
 */
public class Geometry {

    public static double sphereVolume(double r) {
        return ((double) 4 / 3) * Math.PI * r * r * r;
    }

    public static double sphereSurface(double r) {
        return 4 * r * r * Math.PI;
    }

    public static double cylinderVolume(double r, double h) {
        return r * r * Math.PI * h;
    }

    public static double cylinderSurface(double r, double h) {
        return 2 * r * Math.PI * h + 2 * r * r * Math.PI;
    }
}
