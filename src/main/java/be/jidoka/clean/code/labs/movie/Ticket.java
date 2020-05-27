package be.jidoka.clean.code.labs.movie;

public class Ticket {
    private double ticketPrice;
    private ExtraOptions[] extraOptions;

    public Ticket(double ticketPrice, ExtraOptions[] extraOptions) {
        this.ticketPrice = ticketPrice;
        this.extraOptions = extraOptions;
    }
}
