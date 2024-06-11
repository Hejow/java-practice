package hejow.java.practice.effectivejava.item10;

import java.awt.Point;
import java.awt.*;

public class ColorPoint extends java.awt.Point {
    private final Color color;

    public ColorPoint(long x, long y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
//        Point point = new Point(0,1);
//        ColorPoint bluePoint = new ColorPoint(0, 1, Color.BLUE);
//
//        point.equals(bluePoint); //true
//        bluePoint.equals(point); //true

        java.awt.Point point = new Point(0,1);
        ColorPoint bluePoint = new ColorPoint(0, 1, Color.BLUE);
        ColorPoint redPoint = new ColorPoint(0, 1, Color.RED);

        bluePoint.equals(point);//true
        point.equals(redPoint);//true
        bluePoint.equals(redPoint);//false
    }
}
