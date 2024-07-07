package hejow.java.practice.etc.concurrent;

import hejow.java.practice.etc.concurrent.v1.SimpleTicketSeller;
import hejow.java.practice.etc.concurrent.v2.SynchronizedTicketSeller;
import hejow.java.practice.etc.concurrent.v3.ConcurrentQueueTicketSeller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketTest {
  private ExecutorService executorService;

  private final int stock = 100;

  @BeforeEach
  void setup() {
    executorService = Executors.newFixedThreadPool(32);
  }

  @RepeatedTest(10)
  void 티켓_발급_테스트_동시성_미고려() throws InterruptedException {
    // given
    var ticketSeller = new SimpleTicketSeller(stock);

    var latch = new CountDownLatch(stock);

    // when
    for (int i = 0; i < stock; i++) {
      executorService.submit(() -> {
        try {
          var ticket = ticketSeller.sell();
          System.out.println("ticket.toString() = " + ticket.toString());
        } finally {
          latch.countDown();
        }
      });
    }

    latch.await();

    // then
    System.out.println("ticketSeller.countRemainTickets() = " + ticketSeller.countRemainTickets());
    assertTrue(ticketSeller.isSoldOut());
  }

  @RepeatedTest(10)
  void 티켓_발급_테스트_동시성_고려_synchronized() throws InterruptedException {
    // given
    var ticketSeller = new SynchronizedTicketSeller(stock);

    var latch = new CountDownLatch(stock);

    // when
    for (int i = 0; i < stock; i++) {
      executorService.submit(() -> {
        try {
          var ticket = ticketSeller.sell();
          System.out.println("ticket.toString() = " + ticket.toString());
        } finally {
          latch.countDown();
        }
      });
    }

    latch.await();

    // then
    assertTrue(ticketSeller.isSoldOut());
  }

  @RepeatedTest(10)
  void 티켓_발급_테스트_동시성_고려_concurrent_queue() throws InterruptedException {
    // given
    var ticketSeller = new ConcurrentQueueTicketSeller(stock);

    var latch = new CountDownLatch(stock);

    // when
    for (int i = 0; i < stock; i++) {
      executorService.submit(() -> {
        try {
          var ticket = ticketSeller.sell();
          System.out.println("ticket.toString() = " + ticket.toString());
        } finally {
          latch.countDown();
        }
      });
    }

    latch.await();

    // then
    assertTrue(ticketSeller.isSoldOut());
  }
}
