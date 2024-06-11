package hejow.java.practice.etc.lawofdemeter;

public class Theater {
    private final String name;
    private final String location;
    private final TicketSeller ticketSeller;

    public Theater(String name, String location, TicketSeller ticketSeller) {
        this.name = name;
        this.location = location;
        this.ticketSeller = ticketSeller;
    }

    public TicketSeller getTicketSeller() {
        return ticketSeller;
    }

    public int getUnusedTickets() {
        return ticketSeller.countUnusedTicket();
    }
}
