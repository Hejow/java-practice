package hejow.java.practice.designpattern.behavior.state.after.status;

public class Payed implements Status {
    private static final String ERROR_MESSAGE = "[결제 오류] 이미 결제한 건입니다.";
    private static final String DELIVERED = "배달이 완료되었습니다.";

    @Override
    public Status payed(Status status) {
        System.out.println(ERROR_MESSAGE);
        return this;
    }

    @Override
    public Status delivered(Status status) {
        System.out.println(DELIVERED);
        return new Delivered();
    }
}
