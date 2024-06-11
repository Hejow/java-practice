package hejow.java.practice.etc.lawofdemeter;

import java.util.List;

public class TicketSeller {
    private final String name;
    private final List<Ticket> tickets;

    public TicketSeller(String name, List<Ticket> tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int countUnusedTicket() {
        return (int) tickets.stream()
                .filter(ticket -> !ticket.isUsed())
                .count();
    }
}
