package hejow.java.practice.effectivejava.Item1;

// public 생성자
//class Pokemon {
//    private int attack, defense, hp;
//
//    public Pokemon(int attack, int defense, int hp) {
//        this.attack = attack;
//        this.defense = defense;
//        this.hp = hp;
//    }
//}
//
//public class StaticFactoryMethod {
//    public static void main(String[] args) {
//        Pokemon 피카츄 = new Pokemon(5,5,5);
//    }
//}

interface 피카츄 { }

// 정적 팩토리 메서드
class Pokemon {
    private static Pokemon pokemon;
    private int attack, defense, hp;

    private Pokemon(int attack, int defense, int hp) {
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
    }

    public static Pokemon newPokemon() {
        if (pokemon == null) {
            pokemon = new Pokemon(5, 5, 5);
        }
        return pokemon;
    }

//    public static List<피카츄> getInstance() {
//        return new ArrayList<>();
//    }
}

class Grade {
     public static Grade of(int score) {
         if (score == 100) {
             return new Perfect();
         } else if (score > 80) {
             return new Good();
         } else {
             return new Soso();
         }
     }
}

class Perfect extends Grade {};
class Good extends Grade {};
class Soso extends Grade {};

public class StaticFactoryMethod {
    public static void main(String[] args) {
        Pokemon 피카츄 = Pokemon.newPokemon();
    }
}
