package hejow.java.practice.livestudy.abstractclass;

abstract class Aniaml {
    abstract void cry();
}

class Dog extends Aniaml {
    @Override
    void cry() { System.out.println("Woof!"); }
}

class Cat extends Aniaml {
    @Override
    void cry() { System.out.println("Meow!"); }
}

public class AbstractClass {
    public static void main(String[] args) {
        new Dog().cry();
        new Cat().cry();
    }
}
