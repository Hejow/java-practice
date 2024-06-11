package hejow.java.practice.livestudy.Super;

/* class Parent {
    int age = 100;

    String getAge() {
        return "this.age : " + this.age;
    }
}

class Child extends Parent {
    int age = 10;

    @Override
    String getAge() {
        return super.getAge() + ", super.age : " + super.age;
    }
}

public class Live_Study.Super {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.getAge());
    }
} */

class Parent {
    String name;
    int age;

    Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Child extends Parent {
    String sex;

    Child(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }
}

public class Super {
    public static void main(String[] args) {
        Child child = new Child("문희조", 26, "male");
        System.out.println("name : " + child.name + ", age : " + child.age + ", sex : " + child.sex);
    }
}
