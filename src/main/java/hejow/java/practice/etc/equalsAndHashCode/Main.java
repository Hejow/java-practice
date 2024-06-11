package hejow.java.practice.etc.equalsAndHashCode;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyString myStr = new MyString("a");
        String str = "a";

        System.out.println(myStr.equals(str));
        System.out.println(str.equals(myStr));

        Set<Person> people = new HashSet<>();

        people.add(new Person("john", 27));
        people.add(new Person("john", 27));

        System.out.println(people.size()); // 2
    }
}
