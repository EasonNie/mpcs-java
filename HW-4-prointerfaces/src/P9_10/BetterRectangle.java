package P9_10;

import java.awt.*;

/**
 * Created by Eason on 15/10/23.
 */
public class BetterRectangle extends Rectangle {
    public BetterRectangle(int x, int y, int width, int height) {
        super.setLocation(x, y);
        super.setSize(width, height);
    }

    public int getPerimeter() {
        return 2 * (width + height);
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "This is a rectangle: " + super.toString() + " Perimeter:" + getPerimeter() + " Area:" + getArea();
    }
}
