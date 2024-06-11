package hejow.java.practice.livestudy.reflection;

// 힙 영역에 로드된 class 가져오기 테스트
public class GetClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 클래스.class로 가져오기
        Class<Pokemon> pokemonClass = Pokemon.class;

        // 인스턴스.getClass()로 가져오기
        Pokemon pokemon = new Pokemon();
        Class<? extends Pokemon> pokemonClass2 = pokemon.getClass();

        // Class.forName(클래스명)로 가져오기
        Class<?> pokemonClass3 = Class.forName("Live_Study.Reflection.Pokemon");

        System.out.println(System.identityHashCode(pokemonClass));
        System.out.println(System.identityHashCode(pokemonClass2));
        System.out.println(System.identityHashCode(pokemonClass3));
    }
}
