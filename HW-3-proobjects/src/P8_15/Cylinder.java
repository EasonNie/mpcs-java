package P8_15;

/**
 * Created by Eason on 10/15/15.
 */
public class Cylinder implements Shape {
    private double radius;
    private double height;
    private double volume;
    private double surface;

    public Cylinder(double r, double h) {
        this.radius = r;
        this.height = h;
        this.volume = r * r * Math.PI * h;
        this.surface = 2 * r * Math.PI * h + 2 * r * r * Math.PI;
    }

    public void print() {
        System.out.printf("The Volume of cylinder with radius %.2f and height %.2f is %.2f\n",
                this.getRadius(), this.getHeight(), this.getVolume());
        System.out.printf("The Surface of cylinder with radius %.2f and height %.2f is %.2f\n",
                this.getRadius(), this.getHeight(), this.getSurface());
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurface() {
        return surface;
    }
}
