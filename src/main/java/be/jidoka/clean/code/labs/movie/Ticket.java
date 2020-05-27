package be.jidoka.clean.code.labs.movie;

import java.util.List;

public class Ticket {
    private double ticketPrice;
    private List<ExtraOptions> extraOptions;

    public Ticket(double ticketPrice, List<ExtraOptions> extraOptions) {
        this.ticketPrice = ticketPrice;
        this.extraOptions = extraOptions;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateExtraOptions(List<ExtraOptions> extraOptions) {
        double priceOfExtraOptions = 0.0;

        if (extraOptions.contains(ExtraOptions.OVERLENGTH)) priceOfExtraOptions += 1.50;

        if (extraOptions.contains(ExtraOptions.THREE_D)) priceOfExtraOptions += 3.0;

        if (extraOptions.contains(ExtraOptions.SPECIAL_MOVIE_DAY)) priceOfExtraOptions -= 2.0;

        return priceOfExtraOptions;
    }
}
