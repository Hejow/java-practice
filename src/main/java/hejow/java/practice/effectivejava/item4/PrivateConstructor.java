package hejow.java.practice.effectivejava.item4;

public class PrivateConstructor {

    public class UtilityClass {
        public UtilityClass() {
            throw new AssertionError();
        }
    }
}
