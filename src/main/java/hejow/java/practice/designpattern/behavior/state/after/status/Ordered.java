package hejow.java.practice.designpattern.behavior.state.after.status;

public class Ordered implements Status {
    private static final String ERROR_MESSAGE = "[결제 오류] 결제되지 않은 건입니다.";
    private static final String PAYED = "결제가 완료되었습니다.";

    @Override
    public Status payed(Status status) {
        System.out.println(PAYED);
        return new Payed();
    }

    @Override
    public Status delivered(Status status) {
        System.out.println(ERROR_MESSAGE);
        return this;
    }
}
