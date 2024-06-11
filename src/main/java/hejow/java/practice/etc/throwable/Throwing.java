package hejow.java.practice.etc.throwable;

public class Throwing {
    public static class MyClass {
        public static void throwException() {
            try {
                MyClass2.throwException();
            } catch (MyClass2.MyException2 e) {
                throw new MyException1("MyClass1 Throws Exception", e);
            }
        }

        public static class MyException1 extends RuntimeException {
            public MyException1(String message, Throwable cause) {
                super(message, cause);
            }
        }
    }

    public static class MyClass2 {
        public static void throwException() {
            try {
                MyClass3.throwException();
            } catch (MyClass3.MyException3 e) {
                throw new MyException2("MyClass2 Throws Exception", e);
            }
        }

        public static class MyException2 extends RuntimeException {
            public MyException2(String message, Throwable cause) {
                super(message, cause);
            }
        }
    }

    public static class MyClass3 {
        public static void throwException() {
            throw new MyException3("MyClass3 Throws Exception");
        }

        public static class MyException3 extends RuntimeException {
            public MyException3(String message) {
                super(message);
            }
        }
    }
}
