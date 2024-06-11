package hejow.java.practice.etc.classloader;

public class Outer {
    static final String CONSTANT = "outer constant";

    static String field = "outer static field";

    static {
        System.out.println("outer static block");
    }

    public static void call() {
        System.out.println("Outer static method");
    }

    static class Nested {
        static final String CONSTANT = "Nested constant";

        static String field = "Nested static field";

        static {
            System.out.println("Nested static block");
        }

        static void call() {
            System.out.println("Nested static method");
        }
    }

    class Inner {
        static {
            System.out.println("Inner static block");
        }
    }

    public static void main(String[] args) {
//        System.out.println(Nested.CONSTANT);
//        System.out.println(Nested.field);
//        new Nested();
//        Nested.call();
        Inner inner = new Outer().new Inner();
    }
}
