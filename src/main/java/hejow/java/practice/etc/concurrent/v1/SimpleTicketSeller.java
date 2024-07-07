package hejow.java.practice.etc.concurrent.v1;

import hejow.java.practice.etc.concurrent.Ticket;
import hejow.java.practice.etc.concurrent.TicketSeller;

import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleTicketSeller extends TicketSeller {
  public SimpleTicketSeller(int stock) {
    super(IntStream.rangeClosed(1, stock)
      .mapToObj(Ticket::issue)
      .collect(Collectors.toCollection(ArrayDeque::new)));
  }

  @Override
  public Ticket sell() {
    validateEmpty();
    return tickets.poll();
  }
}
