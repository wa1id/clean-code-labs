package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Calculator implements Bill {

    private final List<Double> ticketPrices = new ArrayList<>();
    private double extraPrice = 0.0;

    @Override
    public void startPurchase(int runtime, DayOfWeek dayOfWeek, boolean loge, boolean threeD) {
        if (threeD) {
            extraPrice += 3.0;
        }

        if (runtime > 120) {
            extraPrice += 1.5;
        }
    }

    @Override
    public void addTicket(int age, boolean student) {
        if (student) {
            ticketPrices.add(8.0 + extraPrice);
        } else if (age >= 65) {
            ticketPrices.add(6.0 + extraPrice);
        } else {
            ticketPrices.add(11.0 + extraPrice);
        }
    }

    @Override
    public double finishPurchase() {
        double sum = 0.0;

        for (Double ticketPrice : ticketPrices) {
            if (ticketPrices.size() >= 20) {
                ticketPrice = 6.0 + extraPrice;
            }
            sum += ticketPrice;
        }

        return sum;
    }
}
