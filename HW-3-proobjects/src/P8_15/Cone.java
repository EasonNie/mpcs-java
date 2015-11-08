package P8_15;

/**
 * Created by Eason on 10/15/15.
 */
public class Cone implements Shape {
    private double radius;
    private double height;
    private double volume;
    private double surface;

    public Cone(double r, double h) {
        this.radius = r;
        this.height = h;
        this.volume = r * r * Math.PI * h / 3.0;
        this.surface = Math.PI * r * (r + Math.sqrt(r * r + h * h));
    }

    public void print() {
        System.out.printf("The Volume of cone with radius %.2f and height %.2f is %.2f\n",
                this.getRadius(), this.getHeight(), this.getVolume());
        System.out.printf("The Surface of cone with radius %.2f and height %.2f is %.2f\n",
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
