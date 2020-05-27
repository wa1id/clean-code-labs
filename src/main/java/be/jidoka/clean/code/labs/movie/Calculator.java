package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements Bill {

    private final List<Ticket> ticketPrices = new ArrayList<>();
    private final List<ExtraOptions> extraOptions = new ArrayList<>();

    private static final double RATE_GENERAL_ADMISSION = 11.0;
    private static final double RATE_STUDENT = 8.0;
    private static final double RATE_SENIOR = 6.0;
    private static final double RATE_GROUP = 6.0;
    private static final int GROUP_THRESHOLD = 20;

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
        Ticket ticket = new Ticket(findBestTicketRate(age, student));
        ticketPrices.add(ticket);
    }

    @Override
    public double finishPurchase() {
        double totalSum = 0.0;

        for (Ticket ticket : ticketPrices) {
            if (ticketPrices.size() >= GROUP_THRESHOLD) {
                ticket = new Ticket(RATE_GROUP);
            }

            double sumOfExtraOptions = calculateExtraOptions(extraOptions);
            totalSum += ticket.getTicketPrice() + sumOfExtraOptions;
        }

        return totalSum;
    }

    private double calculateExtraOptions(List<ExtraOptions> extraOptions) {
        double priceOfExtraOptions = 0.0;

        for (ExtraOptions option : extraOptions) {
            priceOfExtraOptions += option.getExtraOptionsPrice();
        }

        return priceOfExtraOptions;
    }

    private double findBestTicketRate(int age, boolean student) {
        if (student) {
            return RATE_STUDENT;
        } else if (isSenior(age)) {
            return RATE_SENIOR;
        } else {
            return RATE_GENERAL_ADMISSION;
        }
    }

    private boolean isSenior(int age) {
        return age >= 65;
    }

}
