package hejow.java.practice.livestudy.finalkeyword;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void increaseAge() { this.age += 1; }

    public void display() {
        System.out.println("이름 : " + this.name + ", 나이 : " + this.age);
    }
}

public class FinalKeyword {
    public static void main(String[] args) {
        final Person Hejow = new Person("문희조", 26);
        Hejow.display();
        Hejow.increaseAge();
        Hejow.display();

        Person HongGilDong = new Person("홍길동", 100);
//        Hejow = HongGilDong; // An Error Occur!
    }
}
