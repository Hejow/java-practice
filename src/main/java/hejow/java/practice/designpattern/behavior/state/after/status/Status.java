package hejow.java.practice.designpattern.behavior.state.after.status;

public interface Status {
    Status payed(Status status);
    Status delivered(Status status);
}
