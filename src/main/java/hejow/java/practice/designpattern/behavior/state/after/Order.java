package hejow.java.practice.designpattern.behavior.state.after;

import hejow.java.practice.designpattern.behavior.state.after.status.Ordered;
import hejow.java.practice.designpattern.behavior.state.after.status.Status;

public class Order {
    private String menu;
    private Status status;

    public Order(String menu) {
        this.menu = menu;
        this.status = new Ordered();
    }

    public Order(String menu, Status status) {
        this.menu = menu;
        this.status = status;
    }

    public void payed() {
        this.status = status.payed(this.status);
    }

    public void delivered() {
        this.status = status.delivered(this.status);
    }
}
