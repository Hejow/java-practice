package hejow.java.practice.effectivejava.item13;

import java.util.Arrays;
import java.util.List;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> skills = Arrays.asList("파괴광선", "누르기");
        Pokemon pokemon = new Pokemon(skills, 10, 10, 10);
        Pokemon clonePokemon = pokemon.clone();

        System.out.println("포켓몬 공격력 : " + pokemon.getAttack());
        System.out.println("복제몬 공격력 : " + clonePokemon.getAttack());

        System.out.println("포켓몬 기술 : " + pokemon.getSkills());
        System.out.println("복제몬 기술 : " + clonePokemon.getSkills());

        // 똑같은 참조를 가진다..!
        System.out.println(System.identityHashCode(pokemon.getAttack()));
        System.out.println(System.identityHashCode(clonePokemon.getAttack()));

        System.out.println("\n" + System.identityHashCode(pokemon.getSkills()));
        System.out.println(System.identityHashCode(clonePokemon.getSkills()));
    }
}
