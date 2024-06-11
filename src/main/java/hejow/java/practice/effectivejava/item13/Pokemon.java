package hejow.java.practice.effectivejava.item13;

import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Cloneable {
    private List<String> skills;
    private int attack;
    private int defense;
    private int hp;

    public Pokemon(List<String> skills, int attack, int defense, int hp) {
        this.skills = skills;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

//    @Override
//    public Pokemon clone() {
//        try {
//            return (Pokemon) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    @Override
    public Pokemon clone() {
        try {
            Pokemon result = (Pokemon) super.clone();
            result.skills = new ArrayList<>(skills);
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getHp() {
        return this.hp;
    }
}
