package hejow.java.practice.etc.classloader;

public class Initialize {
    static {
        System.out.println("block initialized");
    }

    static Field field = new Field();

    public Initialize() {
        System.out.println("constructor initialized");
    }

    public static void main(String[] args) {
        new Initialize();
    }
}

class Field {
    public Field() {
        System.out.println("field initialized");
    }
}
