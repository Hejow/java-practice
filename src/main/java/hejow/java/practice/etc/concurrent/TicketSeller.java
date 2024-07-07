package hejow.java.practice.etc.concurrent;

import java.util.Queue;

public abstract class TicketSeller {
  protected final Queue<Ticket> tickets;

  protected TicketSeller(Queue<Ticket> tickets) {
    this.tickets = tickets;
  }

  public abstract Ticket sell();

  protected void validateEmpty() {
    if (tickets.isEmpty()) {
      throw new IllegalArgumentException("out of ticket stock");
    }
  }

  public boolean isSoldOut() {
    return tickets.isEmpty();
  }

  public int countRemainTickets() {
    return tickets.size();
  }
}
