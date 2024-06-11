package hejow.java.practice.effectivejava.item15;

public class PokemonTrainer {
    private String name;
    private Pokemon pokemon;

    public PokemonTrainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public void choosePokemon() {
        System.out.println(name + "은(는) " + pokemon.getName() + "을 꺼냈다..!");
    }

    public void usePokemonSkill() {
        pokemon.useSkill();
    }
}
