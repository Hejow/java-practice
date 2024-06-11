package hejow.java.practice.effectivejava.item6;

import java.util.regex.Pattern;

public class CreateClass {
    public static void main(String[] args) {
//        String s1 = new String("문자열");
//        String s2 = new String("문자열");
//        String s3 = "문자열";
//        String s4 = String.valueOf("문자열");
//
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s3 == s4);
//        System.out.println(s1.equals(s2));
//        System.out.println(s2.equals(s3));
//        System.out.println(s3.equals(s4));

        String s1 = "He";
        String s2 = "Jow";
        String s3 = s1 + s2;
        String s4 = "HeJow";

        System.out.println((s1 + s2) == s3);
        System.out.println(s3 == s4);
        System.out.println((s1 + s2) == s4);
        System.out.println((s1 + s2).intern() == s3);
        System.out.println((s1 + s2).intern() == s4);
        System.out.println(s3.intern() == s4);
    }

    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static final Pattern ROMAN = Pattern
            .compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
