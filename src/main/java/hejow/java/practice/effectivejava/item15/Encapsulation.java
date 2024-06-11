package hejow.java.practice.effectivejava.item15;

public class Encapsulation {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon("피카츄", "100만 볼트");
        PokemonTrainer trainer = new PokemonTrainer("지우", pokemon);

        trainer.choosePokemon();
        trainer.usePokemonSkill();
    }
}
