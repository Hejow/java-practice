package Inheritance;

class Parent {
    String name;
    int age;

    public void Print() {
        System.out.println("이름 : " + name + ", 나이 : " + age);
    }
}

class Child extends Parent {
    Child(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class basic {
    public static void main(String[] args) {
        Child child = new Child("문희조", 26);
        child.Print();
    }
}