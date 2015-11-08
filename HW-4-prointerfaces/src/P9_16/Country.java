package P9_16;

/**
 * Created by Eason on 15/10/23.
 */
public class Country implements Measurable {
    private String name;
    private double area;

    public Country(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public double getMeasure() {
        return area;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
