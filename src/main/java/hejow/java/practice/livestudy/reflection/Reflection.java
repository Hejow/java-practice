package hejow.java.practice.livestudy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws Exception {
        Class<? extends Pokemon> pokemonClass = Pokemon.class;
        Arrays.stream(pokemonClass.getConstructors()).forEach(System.out::println);

        // 인스턴스 생성하기
        Constructor<? extends Pokemon> constructor = pokemonClass.getConstructor();
        Pokemon pokemon = constructor.newInstance();
        System.out.println(pokemon);

        // 인스턴스 생성하기 (all)
        Constructor<? extends  Pokemon> constructor2 =
                pokemonClass.getConstructor(String.class, int.class, String.class);
        Pokemon 피카츄 = constructor2.newInstance("피카츄", 50, "감전");
        System.out.println(피카츄);

        // 진짜 리플렉션
        Pokemon pokemon2 = new Pokemon("파이리", 100, "화상");
        Class<?> pokemonClass2 = pokemon2.getClass();

        // 리플렉션으로 필드 접근하기
        Field[] fields = pokemonClass2.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(pokemon2));
        }

        fields[1].set(pokemon2, 90);
        System.out.println(pokemon2);

        // 리플렉션으로 메소드 접근하기
        Method printName = pokemonClass2.getDeclaredMethod("printName", String.class);
        printName.invoke(pokemon2, "꼬부기");

        Method printHidden = pokemonClass2.getDeclaredMethod("printHidden");
        printHidden.setAccessible(true);
        printHidden.invoke(pokemon2);
    }
}
