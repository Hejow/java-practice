package hejow.java.practice.effectivejava.Item1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public enum Status {
    Good(100, 75),
    SoSo(74, 40),
    Bad(39, 0);

    private final int maximum;
    private final int minimum;

    private Status(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public static Status of(int point) {
        return Arrays.stream(values())
                .filter(decideStatus(point))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("일치하는 상태가 없습니다!"));
    }

    private static Predicate<Status> decideStatus(int point) {
        return element -> element.maximum >= point && element.minimum <= point;
    }
}
