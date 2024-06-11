package hejow.java.practice.livestudy.Interface;

interface Part {
    String putTogether();

    static void Hello() {
        System.out.println("Hello World!");
    }
    default void Hi() {
        System.out.println("Hi world!");
    }
}

class Engine implements Part {
    public String putTogether() {
        return "Engine" + "을 조립했다!!";
    }
}

class Mechanic {
    public void action(Part part) {
        System.out.println(part.putTogether());
    }
}

public class Interface {
    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        Engine engine = new Engine();
        mechanic.action(engine); // Engine을 조립했다!!
        engine.Hi();
    }
}
