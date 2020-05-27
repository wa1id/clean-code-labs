package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements Bill {

    private final List<Ticket> ticketPrices = new ArrayList<>();
    private final List<ExtraOptions> extraOptions = new ArrayList<>();

    @Override
    public void startPurchase(int runtime, DayOfWeek dayOfWeek, boolean loge, boolean threeD) {
        if (runtime > 120) {
            extraOptions.add(ExtraOptions.OVERLENGTH);
        }

        if (dayOfWeek.equals(DayOfWeek.THURSDAY)) {
            extraOptions.add(ExtraOptions.SPECIAL_MOVIE_DAY);
        }

        if (threeD) {
            extraOptions.add(ExtraOptions.THREE_D);
        }
    }

    @Override
    public void addTicket(int age, boolean student) {
        Ticket ticket;

        if (student) {
            ticket = new Ticket(8.0, extraOptions);
        } else if (age >= 65) {
            ticket = new Ticket(6.0, extraOptions);
        } else {
            ticket = new Ticket(11.0, extraOptions);
        }

        ticketPrices.add(ticket);
    }

    @Override
    public double finishPurchase() {
        double totalSum = 0.0;

        for (Ticket ticket : ticketPrices) {
            if (ticketPrices.size() >= 20) {
                extraOptions.add(ExtraOptions.GROUP);
                ticket = new Ticket(6.0, extraOptions);
            }
            double sumOfExtraOptions = ticket.calculateExtraOptions(extraOptions);
            totalSum += ticket.getTicketPrice() + sumOfExtraOptions;
        }

        return totalSum;
    }

}
