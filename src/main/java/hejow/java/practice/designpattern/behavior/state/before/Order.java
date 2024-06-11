package hejow.java.practice.designpattern.behavior.state.before;

public class Order {
    private String menu;
    private Status status;

    public Order(String menu) {
        this.menu = menu;
        this.status = Status.ORDERED;
    }

    public Order(String menu, Status status) {
        this.menu = menu;
        this.status = status;
    }

    public void payed() {
        if (this.status == Status.ORDERED){
            this.status = Status.PAYED;
            System.out.println("결제가 완료되었습니다.");
        } else if (this.status == Status.DELIVERED) {
            System.out.println("[결제 오류] 이미 배달 완료된 건입니다.");
        } else {
            System.out.println("[결제 오류] 이미 결제한 건입니다.");
        }
    }

    public void delivered() {
        if (this.status == Status.PAYED){
            this.status = Status.DELIVERED;
            System.out.println("배달이 완료되었습니다.");
        } else if (this.status == Status.DELIVERED) {
            System.out.println("[배달 오류] 이미 배달 완료된 건입니다.");
        } else {
            System.out.println("[배달 오류] 결제되지 않은 건입니다.");
        }
    }
}
