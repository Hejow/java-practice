package hejow.java.practice.etc.sealed;

public sealed class Animal permits Person, Animal.Bird {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public static final class Bird extends Animal {
        public Bird(String name) {
            super(name);
        }
    }
}
