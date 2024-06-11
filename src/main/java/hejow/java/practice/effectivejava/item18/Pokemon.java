package hejow.java.practice.effectivejava.item18;

import java.util.List;

public class Pokemon {
    public static final int LEVEL_UP_BONUS = 5;
    private int totalStat;
    private List<String> skills;
    private PokemonType type;

    public Pokemon(int totalStat, List<String> skills, PokemonType type) {
        this.totalStat = totalStat;
        this.skills = skills;
        this.type = type;
    }

    public void levelUp() {
        this.totalStat += LEVEL_UP_BONUS;
    }

    public void learnSkill(String skill) {
        this.skills.add(skill);
    }

    public void attackWith(String skill) throws IllegalArgumentException {
        if (this.skills.contains(skill)) {
            System.out.println(skill + "을 사용했다..!");
        }
        throw new IllegalArgumentException("배우지 않은 기술입니다..!");
    }

    public int getTotalStat() {
        return totalStat;
    }

    public List<String> getSkills() {
        return skills;
    }

    public PokemonType getType() {
        return type;
    }
}
