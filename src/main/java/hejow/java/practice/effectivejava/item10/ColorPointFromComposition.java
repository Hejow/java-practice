package hejow.java.practice.effectivejava.item10;

import java.awt.Point;
import java.awt.*;
import java.util.Objects;

public class ColorPointFromComposition {
    private final java.awt.Point point;
    private final Color color;

    public ColorPointFromComposition(int x, int y, Color color) {
        point = new java.awt.Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    // (아이템6) Point 뷰를 반환한다.
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointFromComposition)) {
            return false;
        }
        ColorPointFromComposition cp = (ColorPointFromComposition) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point)) {
//            return false;
//        }
//    }
}
