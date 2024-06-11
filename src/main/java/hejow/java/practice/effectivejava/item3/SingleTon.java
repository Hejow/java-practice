package hejow.java.practice.effectivejava.item3;

class Pokemon {
    // private static final 필드 방식
    public static final Pokemon INSTANCE = new Pokemon();
    private Pokemon() { }

    // 정적 팩토리 메서드 방식
//    private static final Pokemon INSTANCE = new Pokemon();
//    private Pokemon() { }
//    public static Pokemon getInstance() { return INSTANCE; }
}

//enum Pokemon {
//   INSTANCE;
//}

public class SingleTon {
    public static void main(String[] args) {
    }
}
