package hejow.java.practice.livestudy.reflection;

public class Pokemon {
    public String name;
    protected int stat;
    private String hiddenPassive;

    public Pokemon() {}

    public Pokemon(String name, int stat, String hiddenPassive) {
        this.name = name;
        this.stat = stat;
        this.hiddenPassive = hiddenPassive;
    }

    public void printName(String name) {
        System.out.println("이 포켓몬의 이름은 " + name + "입니다.");
    }

    private void printHidden() {
        System.out.println("히든 패시브는 " + this.hiddenPassive + "입니다.");
    }

    @Override
    public String toString() {
        return "\n포켓몬 이름 : " + name + " 스탯 : " + stat + " 히든 패시브 : " + hiddenPassive;
    }
}
