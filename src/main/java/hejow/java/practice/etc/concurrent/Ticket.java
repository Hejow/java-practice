package hejow.java.practice.etc.concurrent;

public class Ticket {
  private final int id;
  private boolean used;

  private Ticket(int id, boolean used) {
    this.id = id;
    this.used = used;
  }

  public static Ticket issue(int id) {
    return new Ticket(id, false);
  }

  @Override
  public String toString() {
    return "Ticket{" +
           "id=" + id +
           ", used=" + used +
           '}';
  }
}
