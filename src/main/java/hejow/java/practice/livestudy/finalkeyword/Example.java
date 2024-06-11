package hejow.java.practice.livestudy.finalkeyword;


/**
 * 상속을 제한하기 위해서 final 사용
 */
final class MyClass {
    private String name;
    // ...
}

public class Example {
    private final int myValue;

    Example(int myValue) {
        this.myValue = myValue;
    }

    /**
     * 오버라이딩을 막기 위해서 final 사용
     */
    public final void myMethod() {
        // do something..
    }
}
