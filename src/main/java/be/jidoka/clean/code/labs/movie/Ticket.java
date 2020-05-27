package be.jidoka.clean.code.labs.movie;

public class Ticket {
    private final double ticketPrice;

    public Ticket(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
