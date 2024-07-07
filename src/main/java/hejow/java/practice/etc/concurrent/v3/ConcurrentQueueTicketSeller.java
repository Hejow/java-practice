package hejow.java.practice.etc.concurrent.v3;

import hejow.java.practice.etc.concurrent.Ticket;
import hejow.java.practice.etc.concurrent.TicketSeller;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrentQueueTicketSeller extends TicketSeller {
  public ConcurrentQueueTicketSeller(int stock) {
    super(IntStream.rangeClosed(1, stock)
      .mapToObj(Ticket::issue)
      .collect(Collectors.toCollection(ConcurrentLinkedQueue::new)));
  }

  @Override
  public Ticket sell() {
    validateEmpty();
    return tickets.poll();
  }
}
