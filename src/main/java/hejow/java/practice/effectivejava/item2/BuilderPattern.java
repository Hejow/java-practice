package hejow.java.practice.effectivejava.item2;

class Pokemon {
    private final int attack, defense, hp, speed;

//        점층적 생성자 패턴
//        private final int attack, defense, hp;
//
//        public Pokemon(int attack) {
//            this(attack, 0, 0);
//        }
//
//        public Pokemon(int attack, int defense) {
//            this(attack, defense, 0);
//        }
//
//        public Pokemon(int attack, int defense, int hp) {
//            this.attack = attack;
//            this.defense = defense;
//            this.hp = hp;
//        }

//        // 자바빈즈 패턴
//        private int attack = 0;
//        private int defense = 0;
//        private int hp = 0;
//
//        public Pokemon() { };
//
//        public void setAttack(int attack) { this.attack = attack; }
//        public void setDefense(int defense) { this.defense = defense; }
//        public void setHp(int hp) { this.hp = hp; }

    static class Builder {
        // 필수 매개변수
        private final int attack, defense, hp;

        // 선택 매개변수 - 기본값으로 초기화
        private int speed = 5;

        public Builder(int attack, int defense, int hp) {
            this.attack = attack;
            this.defense = defense;
            this.hp = hp;
        }

        public Builder speed(int val) {
            speed = val;
            return this;
        }

        public Pokemon build() {
            return new Pokemon(this);
        }
    }

    private Pokemon(Builder builder) {
        attack = builder.attack;
        defense = builder.defense;
        hp = builder.hp;
        speed = builder.speed;
    }
}

public class BuilderPattern {
    public static void main(String[] ars) {
        Pokemon 피카츄 = new Pokemon.Builder(5, 5, 5).build();
        Pokemon 꼬부기 = new Pokemon.Builder(5, 5, 5).speed(0).build();
    }
}
