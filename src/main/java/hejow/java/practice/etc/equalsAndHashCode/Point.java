package hejow.java.practice.etc.equalsAndHashCode;

import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);

        System.out.println();
        System.out.println("point1 == point2 : " + (point1 == point2));
        System.out.println("point1.equals(point2) : " + point1.equals(point2));
        System.out.println("point1.hashCode() == point2.hashCode() : " + (point1.hashCode() == point2.hashCode()));
    }
}
