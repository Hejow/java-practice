package hejow.java.practice.etc.lawofdemeter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Movie 타이타닉 = new Movie("타이타닉", 2);
        Movie 어바웃타임 = new Movie("어바웃타임", 2);

        List<Ticket> tickets = tickets(타이타닉);
        tickets.addAll(tickets(어바웃타임));
        TicketSeller ticketSeller = new TicketSeller("john", tickets);

        Theater theater = new Theater("CGV 홍대점", "서울특별시 마포구 양화로 153", ticketSeller);

        int unusedTicketCount = (int) theater.getTicketSeller().getTickets().stream()
                .filter(ticket -> !ticket.isUsed())
                .count();

        System.out.println("사용하지 않은 티켓의 수 = " + unusedTicketCount);
        System.out.println("사용하지 않은 티켓의 수2 = " + theater.getUnusedTickets());
    }

    private static List<Ticket> tickets(Movie movie) {
        return IntStream.range(0, 3)
                .mapToObj(i -> new Ticket(movie))
                .collect(Collectors.toList());
    }
}
