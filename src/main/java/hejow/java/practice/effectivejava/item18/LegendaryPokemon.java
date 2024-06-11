package hejow.java.practice.effectivejava.item18;

import java.util.List;

public class LegendaryPokemon {
    private String specialSkill;
    private Pokemon pokemon;

    public LegendaryPokemon(String specialSkill, Pokemon pokemon) {
        this.specialSkill = specialSkill;
        this.pokemon = pokemon;
    }

    // getter, setter...
    public static void main(String[] args) {
        List<String> skills = List.of("용의 숨결", "메탈 크로우");
        LegendaryPokemon diaruga = new LegendaryPokemon("시간의 표효", new Pokemon(680, skills, PokemonType.드래곤));
        System.out.println("디아루가 스텟 : " + diaruga.pokemon.getTotalStat());
        try {
            diaruga.pokemon.attackWith("용의 숨결");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("배우지 않은 기술입니다..!");
        }
    }
}
