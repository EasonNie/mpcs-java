package P8_15;

/**
 * Created by Eason on 10/15/15.
 */
public class Sphere implements Shape {
    private double radius;
    private double volume;
    private double surface;

    public Sphere(double r) {
        this.radius = r;
        this.volume = ((double) 4 / 3) * Math.PI * r * r * r;
        this.surface = 4 * r * r * Math.PI;
    }

    public void print() {
        System.out.printf("The Volume of sphere with radius %.2f is %.2f\n", this.getRadius(), this.getVolume());
        System.out.printf("The Surface of sphere with radius %.2f is %.2f\n", this.getRadius(), this.getSurface());
    }

    public double getRadius() {
        return radius;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurface() {
        return surface;
    }
}
