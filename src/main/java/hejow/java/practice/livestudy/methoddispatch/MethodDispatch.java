package hejow.java.practice.livestudy.methoddispatch;

class Parent {
    void display() { System.out.println("Parent method"); }
}

class Child1 extends Parent {
    @Override
    void display() { System.out.println("Child1 method"); }
}

class Child2 extends Parent {
    @Override
    void display() { System.out.println("Child2 method"); }
}

public class MethodDispatch {
    public static void main(String[] args) {
        Parent parent = new Child2();
        parent.display();
    }
}
