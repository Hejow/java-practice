package hejow.java.practice.livestudy.exception;

public class Exception {
    public static void exceptionTryCatch() {
        try {
            // 예외가 발생할 수 있는 코드
            System.out.println("try문 실행");
            System.out.println(0/0);
            // 예외가 발생하면 다음 문장들은 실행되지 않는다.
            System.out.println("실행되지 않는다!!");
        } catch (ArithmeticException arithmeticException) {
            System.out.println("catch문 실행");
            System.out.println("ArithmeticException 예외 발생");
        } catch (java.lang.Exception exception) {
            // 하나의 try에 여러 개의 catch를 사용할 수 있다.
            try {
                System.out.println("catch문 안에 try문");
            } catch (java.lang.Exception exception1) {
                // 중복된 try-catch문의 참조변수는 중복 x
            }
        } finally {
            System.out.println("finally문 실행");
        }
    }

    public static void exceptionMultiCatch() {
        try {
            System.out.println(1/0);
        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void exceptionThrowError() {
        String name = new String("희조");
        try {
            if (name.equals("희조"))
                throw new IllegalArgumentException("감히 부를 수 없는 이름입니다.");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void exceptionThrowsMethod(int a, int b) throws ArithmeticException {
        System.out.println((float)a / b);
    }

    public class customedException extends java.lang.Exception {
        customedException() {
            super();
        }
    }

    public static void main(String[] args) {
//        exceptionTryCatch();
//        exceptionMultiCatch();
//        exceptionThrowError();
//        try {
//            exceptionThrowsMethod(1,0);
//        } catch(Live_Study.Exception e) {
//            System.out.println("main에서 예외가 처리되었다..!!");
//            System.out.println(e);
//        }
        double a = 12.4;
        int b = 4;
        System.out.println(a%b);
    }
}
