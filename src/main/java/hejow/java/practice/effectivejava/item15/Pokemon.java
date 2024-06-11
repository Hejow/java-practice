package hejow.java.practice.effectivejava.item15;

public class Pokemon {
    private String name;
    private String skill;

    public Pokemon(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return this.name;
    }

    public void useSkill() {
        System.out.println(name + "이(가) " + skill + "을 사용했다..!");
    }
}
