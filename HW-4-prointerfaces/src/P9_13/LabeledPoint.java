package P9_13;

import java.awt.*;

/**
 * Created by Eason on 15/10/23. Reserved.
 */

public class LabeledPoint extends Point {
    private String Label;

    public LabeledPoint(Point point, String label) {
        super(point);
        Label = label;
    }

    public LabeledPoint(int x, int y, String label) {
        this(new Point(x, y), label);
    }

    @Override
    public String toString() {
        return "This is a labeledPoint at " + super.toString() + " with label: " + Label;
    }
}
