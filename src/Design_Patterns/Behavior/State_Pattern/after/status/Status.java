package Design_Patterns.Behavior.State_Pattern.after.status;

public interface Status {
    Status payed(Status status);
    Status delivered(Status status);
}
