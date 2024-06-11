package hejow.java.practice.livestudy.overriding;

class Parent {
    void display() { System.out.println("부모 클래스의 display() 메소드입니다."); }
}

class Child extends Parent {
    @Override
    void display() { System.out.println("자식 클래스의 display() 메소드입니다."); }
}

public class Overriding {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
    }
}
