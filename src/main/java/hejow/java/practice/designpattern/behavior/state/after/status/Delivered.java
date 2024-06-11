package hejow.java.practice.designpattern.behavior.state.after.status;

public class Delivered implements Status {
    private static final String ERROR_MESSAGE = "[배달 오류] 이미 배달 완료된 건입니다.";

    @Override
    public Status payed(Status status) {
        System.out.println(ERROR_MESSAGE);
        return this;
    }

    @Override
    public Status delivered(Status status) {
        System.out.println(ERROR_MESSAGE);
        return this;
    }
}
