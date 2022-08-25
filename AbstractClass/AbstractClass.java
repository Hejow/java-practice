package AbstractClass;

abstract class Aniaml {
    abstract void cry();
}

class Dog extends Aniaml {
    @Override
    void cry() { System.out.println("Woof!"); }
}

class Cat extends Aniaml { }

public class AbstractClass {
    public static void main(String[] args) {
        new Dog().cry(); // Woof!
        new Cat().cry(); // Error occur!!
    }
}
