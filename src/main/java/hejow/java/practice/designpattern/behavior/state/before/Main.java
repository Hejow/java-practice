package hejow.java.practice.designpattern.behavior.state.before;

public class Main {
    public static void main(String[] args) {
        // menus
        String hamburger = "햄버거";
        String pizza = "피자";
        String chicken = "치킨";

        // Status
        Status payed = Status.PAYED;
        Status delivered = Status.DELIVERED;

        // hamburger order
        Order hamburgerOrder = new Order(hamburger);
        hamburgerOrder.payed();
        hamburgerOrder.delivered();

        // pizza order
        Order pizzaOrder = new Order(pizza, payed);
        pizzaOrder.payed();
        pizzaOrder.delivered();

        // chicken order
        Order chickenOrder = new Order(chicken, delivered);
        chickenOrder.payed();
        chickenOrder.delivered();
    }
}
